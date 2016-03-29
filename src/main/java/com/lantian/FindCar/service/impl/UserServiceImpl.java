package com.lantian.FindCar.service.impl;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lantian.FindCar.dao.UserBaseInformation;
import com.lantian.FindCar.dao.UserBaseInformationExample;
import com.lantian.FindCar.mapper.UserBaseInformationMapper;
import com.lantian.FindCar.service.UserService;
import com.lantian.FindCar.util.CommonUtil;

@Service
public class UserServiceImpl implements UserService {

	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserBaseInformationMapper userMapper;
	
	public String login(String phonenum, String password) {
		try{
			UserBaseInformationExample example = new UserBaseInformationExample();
			UserBaseInformationExample.Criteria criteria= example.createCriteria();
			criteria.andPhonenumEqualTo(phonenum);
			List<UserBaseInformation> entityList = userMapper.selectByExample(example);
			if(!CommonUtil.isEmpty(entityList)){
				UserBaseInformation entity = entityList.get(0);
				return "success";
			}else{
				return "fail";
			}
		}catch(Exception e){
			log.error("登陆失败:"+e.getLocalizedMessage());
			return "NO";
		}
	}

}
