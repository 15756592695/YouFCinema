	package com.cinema.config;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* 开启redis缓存。设置key生成策略
* @author xuchaobo
*/
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport{
	@Bean
	public KeyGenerator keyGenerator() {
    	return new KeyGenerator() {
        	@Override
        	public Object generate(Object target, Method method, Object... params) {
	            StringBuilder sb = new StringBuilder();
	            sb.append(target.getClass().getName());
	            sb.append(method.getName());
	            for (Object obj : params) {
	                sb.append(obj.toString());
	            }
	            return sb.toString();
        	}
    	};
	}
	
}
