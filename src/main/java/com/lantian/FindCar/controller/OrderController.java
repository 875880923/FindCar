package com.lantian.FindCar.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.annotation.AccessRequired;
import com.lantian.FindCar.text.ResultText;

@Controller
public class OrderController {
	
	private static Logger log = Logger.getLogger(OrderController.class);
	
	@RequestMapping(value="/placeOrder")
	@ResponseBody
	@AccessRequired
	public String placeOrder(@RequestParam("phonenum")String phonenum,
			@RequestParam("car_cate")String carCate,
			@RequestParam("start_location_name")String startLocationName,
			@RequestParam("start_location_lat")double startLocationLat,
			@RequestParam("start_location_lng")double startLocationLng,
			@RequestParam("end_location_name")String endLocationName,
			@RequestParam("end_location_lat")double endLocationLat,
			@RequestParam("end_location_lng")double endLocationLng
			){
		JSONObject jsonObject = new JSONObject();
		
		
		log.info("用户创建订单: phonenum:"+phonenum+" car_cate:"+carCate+
				" start_location_name:"+startLocationName+" start_location_lat:"+startLocationLat+
				" start_location_lng:"+startLocationLng+" end_location_name:"+endLocationName+
				" end_location_lat:"+endLocationLat+" end_location_lng:"+endLocationLng
				);
		jsonObject.put("result", ResultText.success);
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/getOrder")
	@ResponseBody
	@AccessRequired
	public String getOrder(@RequestParam("phonenum")String phonenum){
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("result", ResultText.success);
		return jsonObject.toString();
	}
}
