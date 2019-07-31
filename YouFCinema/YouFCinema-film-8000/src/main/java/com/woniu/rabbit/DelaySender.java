package com.woniu.rabbit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cinema.pojo.Seats;
import com.woniu.dto.ChooseSeatDto;
/*
 * 缓冲队列
 */
@Configuration
public class DelaySender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(ChooseSeatDto dto, List<Seats> seats) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		map.put("seats", seats);
		
		this.amqpTemplate.convertAndSend("topicExchange", "topic.seats.outofdate", map);
	}
	
}
