package com.woniu.rabbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String,Object> map=new HashMap<>();
		map.put("dto", dto);
		map.put("seats", seats);
		this.amqpTemplate.convertAndSend("topicExchange","topic.product.chooseseat",map);
	}
}
