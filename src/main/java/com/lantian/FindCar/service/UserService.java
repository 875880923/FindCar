package com.lantian.FindCar.service;

public interface UserService {
	
	public boolean updateLoginStatus(String phonenum);
	
	public String getAccessToken(String phoneNum);
	
}
