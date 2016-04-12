package com.lantian.FindCar.service;

public interface DriverService {

	public boolean updateLoginStatus(String phonenum,String carCate);
	
	public String getAccessToken(String phoneNum);
	
	public long getDriverAnimateIdByPhonenum(String phonenum);
	
	public boolean verifyDriverAccessLegal(long driverAnimateId,String access_token);
}
