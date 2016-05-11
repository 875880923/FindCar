package com.lantian.FindCar.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.text.ResultText;

@Controller
public class UserInfoController {

	private static Logger log = Logger.getLogger(UserInfoController.class);
	
	@Value("#{configProperties['upload.path']}")
	private String path; 
	
	@RequestMapping(value="/uploadUserImage",method =RequestMethod.POST)
	@ResponseBody
	public String uploadUserImage(@RequestParam("user_image") CommonsMultipartFile image
			,@RequestParam("phonenum") String phonenum){
		JSONObject jsonObject = new JSONObject();
		try{
			File file = new File(path+"/"+phonenum+".jpg");
			image.transferTo(file);
			jsonObject.put("result", ResultText.success);
		}catch(Exception e){
			jsonObject.put("result", ResultText.fail);
			log.error("上传用户头像失败：",e);
		}
		log.info("phonenum:"+jsonObject.toString());
		return jsonObject.toString();
	}
}
