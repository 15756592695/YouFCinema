package com.woniu.rabbit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	//用户选择的座位
	private final static String QUEUE_NAME="topic.product.chooseseat";
	//用户选择的座位\缓冲队列
	private final static String QUEUE_DELAY="topic.seats.outofdate";
	//死信接收队列
	private final static String QUEUE_DEAD="topic.seats.dead";
	
	@Bean("chooseseat")
	public Queue message(){
		return new Queue(QUEUE_NAME);
	}
	
	@Bean("dead")
	public Queue message3(){
		return new Queue(QUEUE_DEAD);
	}	
	
	//创建死信路由
	@Bean("deadExchange")
	public TopicExchange deadExchange(){
		return new TopicExchange("deadExchange");
	}

	//将死信路由绑定到缓冲队列
	@Bean("outofdate")
	public Queue message2(){
		Map<String, Object> args = new HashMap<>();
        //dlx的名称必须与创建exchange的名称相同
        args.put("x-dead-letter-exchange","deadExchange");
        args.put("x-message-ttl" , 900*1000);//设置队列里消息的ttl的时间30s
        args.put("x-dead-letter-routing-key","topic.seats.dead");
        
        return QueueBuilder.durable(QUEUE_DELAY).withArguments(args).build();

	}
	
	@Bean("topicExchange")
	public TopicExchange topicExchange(){
		return new TopicExchange("topicExchange");
	}
	
	
	@Bean
	public Binding bingdingExchangeMessage1(@Qualifier("topicExchange")TopicExchange topicExchange,Queue chooseseat){
		return BindingBuilder.bind(chooseseat).to(topicExchange).with("topic.product.chooseseat");
	}
	//缓冲队列
	@Bean
	public Binding bingdingExchangeMessage2(@Qualifier("topicExchange")TopicExchange topicExchange,Queue outofdate){
		return BindingBuilder.bind(outofdate).to(topicExchange).with("topic.seats.outofdate");
	}
	//普通队列与死信路由绑定
	@Bean
	public Binding bingdingExchangeMessage3(@Qualifier("deadExchange")TopicExchange topic,@Qualifier("dead")Queue message3){
		return BindingBuilder.bind(message3).to(topic).with("topic.seats.dead");
	}
	
}
