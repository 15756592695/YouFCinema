package com.cinema.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cinema.util.RedisUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisTest {
	/*@Autowired
	private RedisTemplate redisTemplate;	*/
	
	@Autowired
	private RedisUtil redisUtil;

	/*@Test
	public void test(){
		redisTemplate.opsForValue().set("username", "xiaowang");
		String value = (String) redisTemplate.opsForValue().get("username");
		System.out.println(value);
	}*/
	
	@Test
	public void test2(){
		redisUtil.set("address", "wuhouqu");
		String value = (String) redisUtil.get("address");
		System.out.println(value);
	}
}
