package com.lantian.FindCar.service;

public interface ConfirmCodeService {

	public boolean sendConfirmCode(String phonenum);
	
	public boolean verifyConfirmCode(String phonenum,String confirmCode);
	
}
