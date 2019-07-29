package com.woniu.rabbit;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.woniu.dto.ChooseSeatDto;
import com.cinema.pojo.Seats;





@Configuration
public class Sender {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(ChooseSeatDto dto, List<Seats> seats){
		this.amqpTemplate.convertAndSend("topicExchange","topic.product.seckill",dto);
	}
}
