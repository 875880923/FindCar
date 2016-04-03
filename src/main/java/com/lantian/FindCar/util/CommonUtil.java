package com.lantian.FindCar.util;

import java.util.List;

public class CommonUtil {
	
	public static boolean isEmpty(String str){
		if( str==null || "".equals(str) ) return true;
		return false;
	}
	
	public static boolean isNotEmpty(String str){
		if( str!=null && !"".equals(str) ) return true;
		return false;
	}
	
	public static boolean isEmpty(List<?> list){
		if( list==null || list.size()==0) return true;
		return false;
	}
	
	public static boolean isNotEmpty(List<?> list){
		if( list!=null && list.size()!=0) return true;
		return false;
	}
	
}
