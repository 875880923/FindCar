package com.lantian.FindCar.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.service.UserService;

@Controller
public class loginController {
	
	private static Logger log = Logger.getLogger(loginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login") 
	@ResponseBody
	public String login(@RequestParam("phonenum") String phonenum
			,@RequestParam("confirmCode") String confirmCode){
		log.info("验证登陆 phonenum:"+phonenum+" confirmCode:"+confirmCode);
		String token = userService.login(phonenum, confirmCode);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("token", token);
		
		return jsonObject.toString();
	}
	
	
}
