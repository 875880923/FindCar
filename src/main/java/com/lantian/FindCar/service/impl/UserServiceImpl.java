package com.lantian.FindCar.service.impl;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lantian.FindCar.dao.UserAnimateInformation;
import com.lantian.FindCar.dao.UserAnimateInformationExample;
import com.lantian.FindCar.dao.UserBaseInformation;
import com.lantian.FindCar.dao.UserBaseInformationExample;
import com.lantian.FindCar.mapper.UserAnimateInformationMapper;
import com.lantian.FindCar.mapper.UserBaseInformationMapper;
import com.lantian.FindCar.service.UserService;
import com.lantian.FindCar.util.CommonUtil;
import com.lantian.FindCar.util.TokenUtil;

@Service
public class UserServiceImpl implements UserService {

	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserBaseInformationMapper userBaseMapper;
	
	@Autowired
	private UserAnimateInformationMapper userAnimateMapper;

	public String getAccessToken(String phoneNum) {
		try{
			UserAnimateInformationExample example = new UserAnimateInformationExample();
			UserAnimateInformationExample.Criteria criteria = example.createCriteria();
			criteria.andPhonenumEqualTo(phoneNum);
			List<UserAnimateInformation> entityList = userAnimateMapper.selectByExample(example);
			if(!CommonUtil.isEmpty(entityList)){
				UserAnimateInformation entity = entityList.get(0);
				String accessToken = entity.getAccessToken();
				if(CommonUtil.isEmpty(accessToken)){
					accessToken = TokenUtil.getToken();
					entity.setAccessToken(accessToken);
					userAnimateMapper.updateByPrimaryKey(entity);
				}
				return accessToken;
			}
		}catch(Exception e){
			log.error("获取access_token错误："+e.getLocalizedMessage());
		}
		return null;
	}

	public boolean updateLoginStatus(String phonenum) {
		boolean isUpdateSuccess = true;
		try{
			//用户第一次登陆等于注册，需要在数据表中添加相关行
			UserBaseInformationExample baseExample = new UserBaseInformationExample();
			UserBaseInformationExample.Criteria criteria = baseExample.createCriteria();
			criteria.andPhonenumEqualTo(phonenum);
			List<UserBaseInformation> baseList = userBaseMapper.selectByExample(baseExample);
			if(CommonUtil.isEmpty(baseList)){
				UserBaseInformation base = new UserBaseInformation();
				base.setPhonenum(phonenum);
				base.setCreatedTime(new Date());
				userBaseMapper.insert(base);
				baseList = userBaseMapper.selectByExample(baseExample);
			}
			long base_id = baseList.get(0).getId();
			
			
			UserAnimateInformationExample animateExample = new UserAnimateInformationExample();
			UserAnimateInformationExample.Criteria animateCri = animateExample.createCriteria();
			animateCri.andPhonenumEqualTo(phonenum);
			List<UserAnimateInformation> animateList = userAnimateMapper.selectByExample(animateExample);
			if(CommonUtil.isEmpty(animateList)){
				UserAnimateInformation animate = new UserAnimateInformation();
				animate.setPhonenum(phonenum);
				animate.setUserBaseId(base_id);
				userAnimateMapper.insert(animate);
			}
		}catch(Exception e){
			log.error("登陆状态修改失败："+e.getLocalizedMessage());
			isUpdateSuccess = false;
		}
		return isUpdateSuccess;
	}
}
