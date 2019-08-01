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
 * 接收死信的队列
 */
@Configuration
public class GetDeadSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void send(Map<String, Object> map) {
		
		this.amqpTemplate.convertAndSend("deadExchange", "topic.seats.dead", map);
	}

}
