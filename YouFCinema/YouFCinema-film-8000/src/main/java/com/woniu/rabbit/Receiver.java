package com.woniu.rabbit;


import java.io.UnsupportedEncodingException;
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


@Configuration
@RabbitListener(queues="topic.product.chooseseat")
public class Receiver {
	@Autowired
	private Order02Controller orderController;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RabbitHandler
	public void process(Map<String,Object> map){
		ChooseSeatDto dto=(ChooseSeatDto) map.get("dto");
		List<Seats> seats=(List<Seats>) map.get("seats");
		//获取排片id
		Integer scheduleid=dto.getScheduleid();
		//根据排片id获取具体电影的排片信息
		Schedule schedule=scheduleService.findScheduleById(scheduleid);
		//创建传给订单的对象
		SeatToOrderDto sto=new SeatToOrderDto();
		//设置值
		sto.setDate(schedule.getS_date());
		sto.setDimention(schedule.getS_dimension());
		sto.setEndTime(schedule.getS_endtime());
		sto.setFilmName(schedule.getFilm().getF_name());
		BigDecimal discount=new BigDecimal(schedule.getS_discount()*seats.size());
		sto.setPrice(schedule.getFilm().getF_price().multiply(discount));
		sto.setRoomName(schedule.getRoom());
		sto.setSeats(seats);
		sto.setStartTime(schedule.getS_starttime());
		sto.setScheduleid(scheduleid);
		sto.setFilmId(schedule.getS_filmid());
		
		//跳转至订单页面
		String result=orderController.view(sto);
		if(!result.equals("服务器降级")){
			if(true){
				Integer rid=schedule.getS_roomid();
				for(int i=0;i<seats.size();i++){
					Integer row=seats.get(i).getSe_row();
					Integer col=seats.get(i).getSe_col();
					String key="s" + scheduleid + row + col;
					//将已选座位存进redis的hasn表
					/*boolean b= redisUtil.hset("selectedSeats", key, 1);*/
					
					boolean b=redisUtil.set(key, 1,90);
				
					 if(!b){
						 System.out.println("将已选座位存进redis的hasn表,失败");
					 }
					 
				}	
			}			
		}else if(result.equals("服务器降级")){
			//服务器降级
			System.out.println("服务器降级");
		}

			
	}
}
