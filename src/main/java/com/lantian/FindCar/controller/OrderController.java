package com.lantian.FindCar.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.annotation.AccessRequired;
import com.lantian.FindCar.service.OrderService;
import com.lantian.FindCar.service.UserService;
import com.lantian.FindCar.text.OrderText;
import com.lantian.FindCar.text.ResultText;
import com.lantian.FindCar.util.CommonUtil;

@Controller
public class OrderController {
	
	private static Logger log = Logger.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/placeOrder")
	@ResponseBody
	@AccessRequired
	public String placeOrder(@RequestParam("phonenum")String phonenum,
			@RequestParam("car_cate")String carCate,
			@RequestParam("start_location_name")String startName,
			@RequestParam("start_location_lat")double startLat,
			@RequestParam("start_location_lng")double startLng,
			@RequestParam("end_location_name")String endName,
			@RequestParam("end_location_lat")double endLat,
			@RequestParam("end_location_lng")double endLng
			){
		JSONObject jsonObject = new JSONObject();
		long userAnimateId = userService.getUserAnimateIdByPhonenum(phonenum);
		if(userAnimateId==-1){
			//用户不存在
			jsonObject.put("result", ResultText.no_user);
			return jsonObject.toString();
		}
		Date now = new Date();
		long orderId = orderService.createOrder(userAnimateId, carCate, now
				, startName, startLat, startLng, endName, endLat, endLng);
		if(orderId!=-1){
			jsonObject.put("order_id", orderId);
			jsonObject.put("result", ResultText.success);
		}else{
			jsonObject.put("result", ResultText.fail);
		}
		log.info("用户创建订单: order_id:"+orderId+" phonenum:"+phonenum+" car_cate:"+carCate+
				" start_location_name:"+startName+" start_location_lat:"+startLat+
				" start_location_lng:"+startLng+" end_location_name:"+endName+
				" end_location_lat:"+endLat+" end_location_lng:"+endLng
				);
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/getOrder")
	@ResponseBody
	@AccessRequired
	public String getOrder(@RequestParam("phonenum")String phonenum
			,@RequestParam("start")long start
			,@RequestParam("limit")long limit){
		JSONObject jsonObject = new JSONObject();
		long userAnimateId = userService.getUserAnimateIdByPhonenum(phonenum);
		if(userAnimateId==-1){
			//用户不存在
			jsonObject.put("result", ResultText.no_user);
			return jsonObject.toString();
		}
		List<String> orderList = orderService.getUserOrderList(userAnimateId, start, limit);
		jsonObject.put("order_list", orderList);
		jsonObject.put("result", ResultText.success);
		log.info("获取订单列表：phonenum:"+phonenum+" result:"+jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/getOrderDriver")
	@ResponseBody
	@AccessRequired
	public String getOrderDriver(@RequestParam("order_id")long orderId,@RequestParam("phonenum") String phonenum){
		JSONObject jsonObject = new JSONObject();
		long userAnimateId = userService.getUserAnimateIdByPhonenum(phonenum);
		if(userAnimateId==-1){
			//用户不存在
			jsonObject.put("result", ResultText.no_user);
			return jsonObject.toString();
		}
		String orderStatus = orderService.getOrderStatusByOrderId(orderId,userAnimateId);
		
		if(!CommonUtil.isEmpty(orderStatus)){
			long driver_animate_id = -1;
			if(OrderText.driver_accept.equals(orderStatus)){
				driver_animate_id= orderService.getOrderDriverIdByOrderId(orderId, userAnimateId);
			}
			jsonObject.put("driver_animate_id", driver_animate_id);
			jsonObject.put("result", ResultText.success);
		}else{
			jsonObject.put("result", ResultText.fail);
		}
		log.info("查询订单司机ID：phonenum:"+phonenum+" order_id:"+orderId+"  data:"+jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/cancelOrder")
	@ResponseBody
	@AccessRequired
	public String cancelOrder(@RequestParam("order_id")long orderId,@RequestParam("phonenum") String phonenum){
		JSONObject jsonObject = new JSONObject();
		long userAnimateId = userService.getUserAnimateIdByPhonenum(phonenum);
		if(userAnimateId==-1){
			//用户不存在
			jsonObject.put("result", ResultText.no_user);
			return jsonObject.toString();
		}
		boolean is_success = orderService.cancelOrderByOrderId(orderId,userAnimateId);
		if(is_success){
			jsonObject.put("result", ResultText.success);
		}else{
			jsonObject.put("result", ResultText.fail);
		}
		log.info("取消订单：phonenum:"+phonenum+" order_id:"+orderId+" data:"+jsonObject.toString());
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/completeOrder")
	@ResponseBody
	@AccessRequired
	public String completeOrder(@RequestParam("order_id")long orderId,@RequestParam("phonenum") String phonenum){
		JSONObject jsonObject = new JSONObject();
		long userAnimateId = userService.getUserAnimateIdByPhonenum(phonenum);
		if(userAnimateId==-1){
			//用户不存在
			jsonObject.put("result", ResultText.no_user);
			return jsonObject.toString();
		}
		boolean is_success = orderService.completeOrderByOrderId(orderId,userAnimateId);
		if(is_success){
			jsonObject.put("result", ResultText.success);
		}else{
			jsonObject.put("result", ResultText.fail);
		}
		log.info("完成订单：phonenum:"+phonenum+" order_id:"+orderId+" data:"+jsonObject.toString());
		return jsonObject.toString();
	}
	
}
