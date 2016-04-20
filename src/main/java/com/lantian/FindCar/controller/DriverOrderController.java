package com.lantian.FindCar.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.JspAwareRequestContext;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.annotation.DriverAccessRequired;
import com.lantian.FindCar.service.DriverService;
import com.lantian.FindCar.service.OrderService;
import com.lantian.FindCar.service.UserService;
import com.lantian.FindCar.text.ResultText;
import com.lantian.FindCar.util.CommonUtil;

@Controller
public class DriverOrderController {

	private static Logger log = Logger.getLogger(DriverOrderController.class);
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/driver/agreeOrder")
	@ResponseBody
	@DriverAccessRequired
	public String agreeOrder(@RequestParam("order_id")long orderId,@RequestParam("phonenum") String phonenum){
		JSONObject jsonObject = new JSONObject();
		long driverAnimateId = driverService.getDriverAnimateIdByPhonenum(phonenum);
		if(driverAnimateId==-1){
			//用户不存在
			jsonObject.put("result", ResultText.no_driver);
			return jsonObject.toString();
		}
		boolean is_success = orderService.agreeOrderByOrderId(orderId, driverAnimateId);
		if(is_success){
			jsonObject.put("result", ResultText.success);
		}else{
			jsonObject.put("result", ResultText.fail);
		}
		log.info("司机抢单：phonenum:"+phonenum+" order_id:"+orderId+" data:"+jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/driver/getAvailableOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	@DriverAccessRequired
	public String getAvailableOrder(@RequestParam("phonenum") String phonenum){
		JSONObject jsonObject = new JSONObject();
		long driverAnimateId = driverService.getDriverAnimateIdByPhonenum(phonenum);
		if(driverAnimateId==-1){
			//用户不存在
			jsonObject.put("result", ResultText.no_driver);
			return jsonObject.toString();
		}
		List<String> list = orderService.getAvailableOrder();
		if(list!=null){
			jsonObject.put("order_list", list); 
			jsonObject.put("result", ResultText.success);
		}else{
			jsonObject.put("result", ResultText.fail);
		}
		log.info("司机查询未接单订单：phonenum:"+phonenum+" data:"+jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/driver/getUserInfo")
	@ResponseBody
	@DriverAccessRequired
	public String getUserInfo(@RequestParam("order_id")long orderId,@RequestParam("phonenum") String phonenum){
		JSONObject jsonObject = new JSONObject();
		long driverAnimateId = driverService.getDriverAnimateIdByPhonenum(phonenum);
		if(driverAnimateId==-1){
			//用户不存在
			jsonObject.put("result", ResultText.no_driver);
			return jsonObject.toString();
		}
		long userAnimateId = orderService.getOrderUserIdByOrderId(orderId, driverAnimateId);
		if(userAnimateId==-1){
			jsonObject.put("result", ResultText.fail);
			return jsonObject.toString();
		}
		String userInfo = userService.getUserInfo(userAnimateId);
		if(CommonUtil.isNotEmpty(userInfo)){
			jsonObject.put("result", ResultText.success);
			jsonObject.put("user_info", userInfo);
		}else{
			jsonObject.put("result", ResultText.fail);
		}
		return jsonObject.toString();
	}
}
