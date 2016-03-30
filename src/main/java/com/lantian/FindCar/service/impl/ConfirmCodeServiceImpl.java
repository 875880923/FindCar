package com.lantian.FindCar.service.impl;

import java.util.Date;
import java.util.List;

import javax.security.auth.login.CredentialException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lantian.FindCar.dao.ConfirmCode;
import com.lantian.FindCar.dao.ConfirmCodeExample;
import com.lantian.FindCar.mapper.ConfirmCodeMapper;
import com.lantian.FindCar.service.ConfirmCodeService;
import com.lantian.FindCar.util.CommonUtil;
import com.lantian.FindCar.util.ConfirmCodeUtil;

@Service
public class ConfirmCodeServiceImpl implements ConfirmCodeService{
	
	private static Logger log = Logger.getLogger(ConfirmCodeServiceImpl.class);
	
	//验证码失效时间 5 分钟
	private static int cofirmcode_dead_time = 5;
	
	@Autowired
	private ConfirmCodeMapper codeMapper;
	
	public boolean sendConfirmCode(String phonenum){
		try{
		String confirmCodeStr = ConfirmCodeUtil.getConfirmCode();
		ConfirmCode code = new ConfirmCode();
		code.setCreateTime(new Date());
		code.setPhonenum(phonenum);
		code.setConfirmcode(confirmCodeStr);
		codeMapper.insert(code);
		//调用服务发送验证码到用户手机
		
		log.info("已发送验证码：phonenum:"+phonenum+" confirmCode:"+confirmCodeStr);
		}catch(Exception e){
			log.error("发送验证码失败！"+e.getLocalizedMessage());
			return false;
		}
		return true;
	}

	public boolean verifyConfirmCode(String phonenum, String confirmCode) {
		boolean isLegal = false;
		try{
			ConfirmCodeExample example = new ConfirmCodeExample();
			ConfirmCodeExample.Criteria criteria = example.createCriteria();
			criteria.andPhonenumEqualTo(phonenum);
			criteria.andConfirmcodeEqualTo(confirmCode);
			Date time = new Date(new Date().getTime()-cofirmcode_dead_time*60000);
			List<ConfirmCode> list = codeMapper.selectByExample(example);
			if(!CommonUtil.isEmpty(list)){
				ConfirmCode code = list.get(0);
				if(code.getCreateTime().getTime()>=time.getTime()){
					isLegal=true;
				}else{
					log.info("验证码超时！phonenum："+phonenum+" confirmCode:"+confirmCode);
				}
			}
		}catch(Exception e){
			log.error("确认验证码出错"+e.getLocalizedMessage());
		}
		return isLegal;
	}
	
}
