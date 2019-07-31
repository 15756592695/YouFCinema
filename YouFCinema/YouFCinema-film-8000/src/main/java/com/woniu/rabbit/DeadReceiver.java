package com.woniu.rabbit;


import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import com.cinema.interfaces.Order02Controller;
import com.cinema.pojo.Seats;
import com.cinema.util.RedisUtil;
import com.woniu.dto.ChooseSeatDto;
import com.woniu.service.ScheduleService;

/*
 * 十五分钟后删除redis中的已选座位
 */
@Configuration
@RabbitListener(queues="topic.seats.dead")
public class DeadReceiver {
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private ScheduleService scheduleService;
	
	@RabbitHandler
	public void process(Map<String,Object> map){
		System.out.println("dead  receiver-----:"+map);
		//获取
		ChooseSeatDto dto=(ChooseSeatDto) map.get("dto");
		List<Seats> seats=(List<Seats>) map.get("seats");
		//获取排片id
		Integer scheduleid=dto.getScheduleid();
		//遍历用户已选的座位集合
		for(int i=0;i<seats.size();i++){
			Integer row=seats.get(i).getSe_row();
			Integer col=seats.get(i).getSe_col();
			String key="s" + scheduleid + row + col;
			
			//删除hash表中的已选座位
			redisUtil.hdel("selectedSeats", key);
			
		}	
	}
}
