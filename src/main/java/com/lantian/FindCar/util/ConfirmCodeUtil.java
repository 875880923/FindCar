package com.lantian.FindCar.util;

import java.util.Random;

public class ConfirmCodeUtil {

	public static int confirm_code_length = 6;
	
	
	private static char[] chars={'1','2','3','4','5','6','7','8','9','0'};
	
	public static String getConfirmCode(){
		String confirmCode = "";
		Random rand = new Random(System.currentTimeMillis());
		int listSize = chars.length;
		for(int i=0;i<confirm_code_length;i++){
			int index = ((rand.nextInt()%listSize)+listSize)%listSize;
			confirmCode += chars[index];
		}
		return confirmCode;
	}
}
