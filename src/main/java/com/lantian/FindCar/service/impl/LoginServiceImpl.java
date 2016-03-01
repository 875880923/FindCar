package com.lantian.FindCar.service.impl;


import org.apache.log4j.Logger;

import com.lantian.FindCar.service.LoginService;


public class LoginServiceImpl implements LoginService {

	static Logger logger = Logger.getLogger(LoginServiceImpl.class.getName());
	
	public String login(String username, String password) {
		if(username.equals("lantian")&&password.equals("123456")){
			logger.info("user login sucessed");
			return "YES";
		}else{
			logger.info("user login failed");
			return "NO";
		}
	}

}
