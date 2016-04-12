package com.lantian.FindCar.service;

import java.util.Date;
import java.util.List;

public interface OrderService {

	public long createOrder(long userAnimateId,String carCate,Date time,String startName
			,double startLat,double startLng,String endName,double endLat,double endLng);
	
	public long getOrderIdByUserAnimateidAndTime(long userAnimateId,Date time);
	
	public String getOrderStatusByOrderId(long orderId,long userAnimateId);
	
	public boolean cancelOrderByOrderId(long orderId,long userAnimateId);
	
	public long getOrderDriverIdByOrderId(long orderId,long userAnimateId);
	
	public boolean completeOrderByOrderId(long orderId,long userAnimateId);
	
	public List<String> getUserOrderList(long userAnimateId,long start,long limit);
	
	public boolean agreeOrderByOrderId(long orderId,long driverAnimateId);
	
	public List<String> getAvailableOrder();
}
