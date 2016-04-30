package com.lantian.FindCar.util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.core.RLock;

public class RedisLockUtil {
	private Logger log = Logger.getLogger(RedisLockUtil.class);
	
	private static String host = "115.28.56.175:6379";
	private static Config config;
	private static RedissonClient client;
	static{
		config = new Config();
		//config.setUseLinuxNativeEpoll(true);
		config.useSingleServer().setAddress(host).setConnectionPoolSize(5).setConnectTimeout(3000);
		client = Redisson.create(config);
	}
	
	private RLock lock;
	public RedisLockUtil(String lockName) {
		try{
			lock = client.getLock(lockName);
		}catch(Exception e){
        	log.error("获取redis锁错误",e);
        }
	}
	
	public boolean lock(){
		boolean isSuccess = false;
		try {
			isSuccess= lock.tryLock(1, 10, TimeUnit.SECONDS);
        }catch(Exception e){
        	log.error("redis 加锁错误",e);
        }
		return isSuccess;
	}
	
	public void unlock(){
		try {
			if(lock!=null){
				lock.unlock();
			}
        }catch(Exception e){
        	log.error("redis 解锁错误",e);
        }
	}

}
