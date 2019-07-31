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
//@Configuration
public class RedisDataLoad implements InitializingBean{
	
	@Autowired
	private SeatsService seatsService;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public void afterPropertiesSet() throws Exception {
		/*//获取影院所有坐位
		List<Seats> seats=seatsService.getAllSeats();
		for(int i=0;i<seats.size();i++){
			Seats seat=seats.get(i);
			
			int roomid=seat.getSe_roomid();
			int seatNum=seat.getSe_num();
			//将座位信息存在redis,键为影厅id+座位编号
			redisUtil.set(""+roomid+seatNum, 1);
		}*/
		
	}

}
