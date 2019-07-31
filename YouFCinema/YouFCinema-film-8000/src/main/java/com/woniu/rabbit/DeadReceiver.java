package com.woniu.rabbit;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.woniu.dto.ChooseSeatDto;
import com.cinema.dto.SeatToOrderDto;
import com.cinema.interfaces.Order02Controller;
import com.cinema.pojo.Schedule;
import com.cinema.pojo.Seats;
import com.cinema.util.RedisUtil;
import com.woniu.service.ScheduleService;


/*@Configuration
@RabbitListener(queues="topic.seats.dead")*/
public class DeadReceiver {
	@Autowired
	private Order02Controller orderController;
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private ScheduleService scheduleService;
	
	@RabbitHandler
	public void process(Map<String,Object> map){
		System.out.println("deadreceiver-----:"+map);
		
	}
}
