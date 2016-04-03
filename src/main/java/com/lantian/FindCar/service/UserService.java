package com.lantian.FindCar.service;

public interface UserService {
	
	public boolean updateLoginStatus(String phonenum);
	
	public String getAccessToken(String phoneNum);
	
	public long getUserAnimateIdByPhonenum(String phonenum);
	
	public boolean verifyUserAccessLegal(long userAnimateId,String access_token);
}
