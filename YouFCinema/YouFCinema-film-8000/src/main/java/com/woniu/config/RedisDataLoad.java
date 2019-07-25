package com.woniu.config;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cinema.pojo.Seats;
import com.cinema.util.RedisUtil;
import com.woniu.service.SeatsService;
/*
 * 当容器初始化bean对象的时候，就执行afterProperties方法
 */
@Configuration
public class RedisDataLoad implements InitializingBean{
	
	@Autowired
	private SeatsService seatsService;
	@Autowired
	private RedisUtil redisUtil;
	/*@Override
	public void afterPropertiesSet() throws Exception {
		Product product=service.getProductNumber(1);
		//将商品库存放在Redis缓存
		redisUtil.set("1",product.getP_number());
		//设置Redis秒杀时间
		redisUtil.set("dateTime",System.currentTimeMillis()+60*1000);
	}*/

	@Override
	public void afterPropertiesSet() throws Exception {
		//获取影院所有坐位
		List<Seats> seats=seatsService.getAllSeats();
		//将坐位数据存在Redis
		/*redisUtil.set(key, value)*/
	}

}
