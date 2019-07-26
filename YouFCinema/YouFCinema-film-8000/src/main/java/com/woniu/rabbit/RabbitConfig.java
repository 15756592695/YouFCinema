package com.woniu.rabbit;





import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	private final static String QUEUE_NAME="topic.product.chooseseat";
	
	@Bean
	public Queue message(){
		return new Queue(QUEUE_NAME);
	}
	
	@Bean
	public TopicExchange topicExchange(){
		return new TopicExchange("topicExchange");
	}
	
	@Bean
	public Binding bingdingExchangeMessage(TopicExchange topic,Queue message){
		return BindingBuilder.bind(message).to(topic).with("topic.product.chooseseat");
	}
	
}
