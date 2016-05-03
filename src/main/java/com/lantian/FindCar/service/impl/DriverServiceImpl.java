package com.lantian.FindCar.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.dao.DriverAnimateInformation;
import com.lantian.FindCar.dao.DriverAnimateInformationExample;
import com.lantian.FindCar.dao.DriverBaseInformation;
import com.lantian.FindCar.dao.DriverBaseInformationExample;
import com.lantian.FindCar.dao.UserAnimateInformation;
import com.lantian.FindCar.dao.UserBaseInformation;
import com.lantian.FindCar.mapper.DriverAnimateInformationMapper;
import com.lantian.FindCar.mapper.DriverBaseInformationMapper;
import com.lantian.FindCar.service.DriverService;
import com.lantian.FindCar.util.CommonUtil;
import com.lantian.FindCar.util.TokenUtil;

@Service
public class DriverServiceImpl implements DriverService {

	private static Logger log = Logger.getLogger(DriverServiceImpl.class);
	
	@Autowired
	private DriverBaseInformationMapper driverBaseMapper;
	@Autowired
	private DriverAnimateInformationMapper driverAnimateMapper;
	
	public boolean updateLoginStatus(String phonenum, String carCate) {
		boolean isUpdateSuccess = true;
		try{
			//用户第一次登陆等于注册，需要在数据表中添加相关行
			DriverBaseInformationExample baseExample = new DriverBaseInformationExample();
			DriverBaseInformationExample.Criteria criteria = baseExample.createCriteria();
			criteria.andPhonenumEqualTo(phonenum);
			List<DriverBaseInformation> baseList = driverBaseMapper.selectByExample(baseExample);
			if(CommonUtil.isEmpty(baseList)){
				DriverBaseInformation base = new DriverBaseInformation();
				base.setPhonenum(phonenum);
				base.setCarCate(carCate);
				base.setCreateTime(new Date());
				driverBaseMapper.insertSelective(base);
				baseList = driverBaseMapper.selectByExample(baseExample);
			}
			long base_id = baseList.get(0).getId();
			
			
			DriverAnimateInformationExample animateExample = new DriverAnimateInformationExample();
			DriverAnimateInformationExample.Criteria animateCri = animateExample.createCriteria();
			animateCri.andPhonenumEqualTo(phonenum);
			List<DriverAnimateInformation> animateList = driverAnimateMapper.selectByExample(animateExample);
			if(CommonUtil.isEmpty(animateList)){
				DriverAnimateInformation animate = new DriverAnimateInformation();
				animate.setPhonenum(phonenum);
				animate.setDriverBaseId(base_id);
				driverAnimateMapper.insertSelective(animate);
			}
		}catch(Exception e){
			log.error("司机登陆状态修改失败：",e);
			isUpdateSuccess = false;
		}
		return isUpdateSuccess;
	}
	
	public String getAccessToken(String phoneNum) {
		try{
			DriverAnimateInformationExample example = new DriverAnimateInformationExample();
			DriverAnimateInformationExample.Criteria criteria = example.createCriteria();
			criteria.andPhonenumEqualTo(phoneNum);
			List<DriverAnimateInformation> entityList = driverAnimateMapper.selectByExample(example);
			if(!CommonUtil.isEmpty(entityList)){
				DriverAnimateInformation entity = entityList.get(0);
				String accessToken = entity.getAccessToken();
				if(CommonUtil.isEmpty(accessToken)){
					accessToken = TokenUtil.getToken();
					entity.setAccessToken(accessToken);
					driverAnimateMapper.updateByPrimaryKey(entity);
				}
				return accessToken;
			}
		}catch(Exception e){
			log.error("获取司机access_token错误：",e);
		}
		return null;
	}

	public long getDriverAnimateIdByPhonenum(String phonenum) {
		long driverAnimateId = -1;
		try{
			DriverAnimateInformationExample example = new DriverAnimateInformationExample();
			DriverAnimateInformationExample.Criteria criteria = example.createCriteria();
			criteria.andPhonenumEqualTo(phonenum);
			List<DriverAnimateInformation> list = driverAnimateMapper.selectByExample(example);
			if(!CommonUtil.isEmpty(list)){
				DriverAnimateInformation entity = list.get(0);
				driverAnimateId = entity.getId();
			}
		}catch(Exception e){
			log.error("获取司机animateId失败:",e);
		}
		return driverAnimateId;
	}

	public boolean verifyDriverAccessLegal(long driverAnimateId, String access_token) {
		boolean isLegal = false;
		try{
			DriverAnimateInformation entity = driverAnimateMapper.selectByPrimaryKey(driverAnimateId);
			if(null!=entity){
				if(access_token.equals(entity.getAccessToken())){
					isLegal = true;
				}
			}
		}catch(Exception e){
			log.error("验证司机access Legal失败：",e);
		}
		return isLegal;
	}

	public String getDriverInfo(long driverAnimateId) {
		JSONObject userInfoJson = new JSONObject();
		try{
			DriverAnimateInformation entity = driverAnimateMapper.selectByPrimaryKey(driverAnimateId);
			if(entity!=null){
				DriverBaseInformation baseEntity = driverBaseMapper.selectByPrimaryKey(entity.getDriverBaseId());
				userInfoJson.put("driver_phonenum", baseEntity.getPhonenum());
				userInfoJson.put("driver_name", baseEntity.getName());
			}
		}catch(Exception e){
			log.error("获取司机信息失败:",e);
		}
		return userInfoJson.toString();
	}


}
