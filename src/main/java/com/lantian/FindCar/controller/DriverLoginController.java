package com.lantian.FindCar.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.service.ConfirmCodeService;
import com.lantian.FindCar.service.DriverService;
import com.lantian.FindCar.text.ResultText;

@Controller
public class DriverLoginController {
	
	private static Logger log = Logger.getLogger(loginController.class);
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private ConfirmCodeService codeService;
	
	@RequestMapping(value="/driver/login") 
	@ResponseBody
	public String login(@RequestParam("phonenum") String phonenum
			,@RequestParam("confirmCode") String confirmCode
			,@RequestParam("car_cate") String carCate){
		JSONObject jsonObject = new JSONObject();
		log.info("验证登陆 phonenum:"+phonenum+" confirmCode:"+confirmCode);
		boolean isLoginSuccess = true;
		
		//确认验证码
		if(codeService.verifyConfirmCode(phonenum, confirmCode)){
			//更改用户状态
			if(driverService.updateLoginStatus(phonenum,carCate)){
				String access_token = driverService.getAccessToken(phonenum);
				jsonObject.put("access_token", access_token);
			}else{
				isLoginSuccess = false;
			}
		}else{
			isLoginSuccess = false;
		}
		if(isLoginSuccess){
			jsonObject.put("result", ResultText.success);
		}else{
			jsonObject.put("result", ResultText.fail);
		}
		log.info("司机登陆：phonenum:"+phonenum+" result:"+jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/driver/getConfirmCode")
	@ResponseBody
	public String getConfirmCode(@RequestParam("phonenum") String phonenum){
		JSONObject jsonObject = new JSONObject();
		if(codeService.sendConfirmCode(phonenum)){
			jsonObject.put("result", ResultText.success);
		}else{
			jsonObject.put("result", ResultText.error);
		}
		log.info("获取司机验证码：phonenum:"+phonenum+" result:"+jsonObject.toString());
		return jsonObject.toString();
	}
	
}
