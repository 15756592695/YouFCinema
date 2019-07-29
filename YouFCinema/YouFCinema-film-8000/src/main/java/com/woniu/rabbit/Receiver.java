package com.woniu.rabbit;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

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
	
	@RabbitHandler
	public void process(ChooseSeatDto dto,List<Seats> seats){
		//获取排片id
		Integer scheduleid=dto.getScheduleid();
		//根据排片id获取具体电影的排片信息
		Schedule schedule=scheduleService.findScheduleById(scheduleid);
		
		SeatToOrderDto sto=new SeatToOrderDto();
		
		sto.setDate(schedule.getS_date());
		sto.setDimention(schedule.getS_dimension());
		sto.setEndTime(schedule.getS_endtime());
		sto.setFilmName(schedule.getFilm().getF_name());
		BigDecimal discount=new BigDecimal(schedule.getS_discount());
		sto.setPrice(schedule.getFilm().getF_price().multiply(discount));
		sto.setRoomName(schedule.getRoom());
		sto.setSeats(seats);
		sto.setStartTime(schedule.getS_starttime());
		sto.setScheduleid(scheduleid);
		sto.setFilmId(schedule.getS_filmid());
		
		//跳转至订单页面
		SeatToOrderDto result=orderController.addOrder(sto);
		if(!result.getFilmName().equals("defeat")){
			Integer rid=schedule.getS_roomid();
			for(int i=0;i<seats.size();i++){
				Integer row=seats.get(i).getSe_row();
				Integer col=seats.get(i).getSe_col();
				String key="" + scheduleid + rid + row + col;
				//将已选座位存进redis,在十五分钟之后移除redis中的座位
				 boolean boo=redisUtil.set(key,1,900);
				
			}			
		}else if(result.getFilmName().equals("defeat")){
			//服务器降级
		
		}

			/*
			//向数据库添加订单并减少库存
			service.addOrder(newOrder,dto.getGoodsid());
			//
			int number=(int) redisUtil.get(dto.getGoodsid()+"");
			redisUtil.set(dto.getGoodsid()+"",--number);
	
			//订单创建后，Redis添加seckillOrder
			redisUtil.hset("seckillOrder", dto.getUserid()+"", "ok");*/
	}
}
