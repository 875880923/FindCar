package com.lantian.FindCar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.text.ResultText;

@Controller
public class AroundDriverController {
	
	private static Logger log = Logger.getLogger(AroundDriverController.class);
	
	private static double lat_span = 0.05;
	private static double lng_span = 0.05;
	
	@RequestMapping(value="/aroundDriver")
	@ResponseBody
	public String getAroundDriverLocationList(@RequestParam("lat") Double lat,
			@RequestParam("lng") Double lng){
		JSONObject jsonObj = new JSONObject();
		Random rand = new Random(System.currentTimeMillis());
		List<JSONObject> list = new ArrayList<JSONObject>();
		int locationSize = (rand.nextInt()%10)+15;
		for(int i=0;i<locationSize;i++){
			double newLat = lat + lat_span*(rand.nextDouble()-0.5);
			double newLng = lng + lng_span*(rand.nextDouble()-0.5);
			JSONObject locationJson = new JSONObject();
			locationJson.put("lat",newLat);
			locationJson.put("lng",newLng);
			list.add(locationJson);
		}
		jsonObj.put("around_driver_location_size", locationSize);
		jsonObj.put("around_driver_location_list", list);
		jsonObj.put("result", ResultText.success);
		log.info("获取附近司机 lat:"+lat+" lng:"+lng+" json:"+jsonObj.toString());
		return jsonObj.toString();
	}
	
}
