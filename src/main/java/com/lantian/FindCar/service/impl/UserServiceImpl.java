package com.lantian.FindCar.service.impl;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
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
			log.error("获取access_token错误：",e);
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
				userBaseMapper.insertSelective(base);
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
				userAnimateMapper.insertSelective(animate);
			}
		}catch(Exception e){
			log.error("登陆状态修改失败：",e);
			isUpdateSuccess = false;
		}
		return isUpdateSuccess;
	}

	public long getUserAnimateIdByPhonenum(String phonenum) {
		long userAnimateId = -1;
		try{
			UserAnimateInformationExample example = new UserAnimateInformationExample();
			UserAnimateInformationExample.Criteria criteria = example.createCriteria();
			criteria.andPhonenumEqualTo(phonenum);
			List<UserAnimateInformation> list = userAnimateMapper.selectByExample(example);
			if(!CommonUtil.isEmpty(list)){
				UserAnimateInformation entity = list.get(0);
				userAnimateId = entity.getId();
			}
		}catch(Exception e){
			log.error("获取用户animateId失败:",e);
		}
		return userAnimateId;
	}

	public boolean verifyUserAccessLegal(long userAnimateId, String access_token) {
		boolean isLegal = false;
		try{
			UserAnimateInformation entity = userAnimateMapper.selectByPrimaryKey(userAnimateId);
			if(null!=entity){
				if(access_token.equals(entity.getAccessToken())){
					isLegal = true;
				}
			}
		}catch(Exception e){
			log.error("验证用户access Legal失败：",e);
		}
		return isLegal;
	}

	public String getUserInfo(long userAnimateId) {
		JSONObject userInfoJson = new JSONObject();
		try{
			UserAnimateInformation entity = userAnimateMapper.selectByPrimaryKey(userAnimateId);
			if(entity!=null){
				UserBaseInformation baseEntity = userBaseMapper.selectByPrimaryKey(entity.getUserBaseId());
				userInfoJson.put("user_phonenum", baseEntity.getPhonenum());
				userInfoJson.put("user_name", baseEntity.getName());
			}
		}catch(Exception e){
			log.error("获取用户信息失败:",e);
		}
		return userInfoJson.toString();
	}
}
