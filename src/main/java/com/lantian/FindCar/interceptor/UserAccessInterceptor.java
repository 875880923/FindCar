package com.lantian.FindCar.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.lantian.FindCar.annotation.AccessRequired;
import com.lantian.FindCar.service.UserService;
import com.lantian.FindCar.text.ResultText;
import com.lantian.FindCar.util.CommonUtil;

public class UserAccessInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger log = Logger.getLogger(UserAccessInterceptor.class);
	
	@Autowired
	private UserService userService;
	
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
		try{
			JSONObject requestJson = new JSONObject(request.getParameterMap());
			log.info("request: "+requestJson.toString());
	        HandlerMethod handlerMethod = (HandlerMethod) handler;
	        Method method = handlerMethod.getMethod();
	        AccessRequired annotation = method.getAnnotation(AccessRequired.class);
	        if (annotation != null) {
	        	JSONObject jsonObject = new JSONObject();
	           String access_token = request.getParameter("access_token");
	           String phonenum = request.getParameter("phonenum");
	           if(CommonUtil.isNotEmpty(access_token)&&CommonUtil.isNotEmpty(phonenum)){
	        	   long userAnimateId = userService.getUserAnimateIdByPhonenum(phonenum);
	        	   if(userAnimateId!=-1){
	        		   if(userService.verifyUserAccessLegal(userAnimateId, access_token)){
	        			   return true;
	        		   }else{
	        			   jsonObject.put("result", ResultText.access_login_fail);
	        		   }
	        	   }else{
	        		   jsonObject.put("result", ResultText.no_user);
	        	   }
	           }else{
	        	   jsonObject.put("result", ResultText.no_login);
	           }
	           log.info("access_token拦截：phonenum:"+phonenum+" result:"+jsonObject.toString());
	           response.getWriter().write(jsonObject.toString());
	    	   return false;
	        }
		}catch(Exception e){
			log.error("拦截器异常：",e);
			return false;
		}
        return true;
    }
}
