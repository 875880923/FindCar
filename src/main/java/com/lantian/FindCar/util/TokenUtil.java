package com.lantian.FindCar.util;

import java.util.Random;

public class TokenUtil {
	
	private static int token_length = 32;
	
	private static char[] chars={'Q', '@', '8', 'y', '%', '^', '5', 'Z', '(', 'G', '_', 'O', '`',  
            'S', '-', 'N', '<', 'D', '{', '}', '[', ']', 'h', ';', 'W', '.',  
            '/', '|', ':', '1', 'E', 'L', '4', '&', '6', '7', '#', '9', 'a',  
            'A', 'b', 'B', '~', 'C', 'd', '>', 'e', '2', 'f', 'P', 'g', ')',  
            '?', 'H', 'i', 'X', 'U', 'J', 'k', 'r', 'l', '3', 't', 'M', 'n',  
            '=', 'o', '+', 'p', 'F', 'q', '!', 'K', 'R', 's', 'c', 'm', 'T',  
            'v', 'j', 'u', 'V', 'w', ',', 'x', 'I', '$', 'Y', 'z', '*'};

	public static String getToken(){
		String token ="";
		Random rand = new Random(System.currentTimeMillis());
		int listSize = chars.length;
		for(int i=0;i<token_length;i++){
			int index = ((rand.nextInt()%listSize)+listSize)%listSize;
			token += chars[index];
		}
		return token;
	}
	
	public static void main(String[] args) {
		System.out.println(TokenUtil.getToken());
	}
}
