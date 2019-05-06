package com.rabbitmq.producter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

//生产者
public class Producter {

	private RabbitTemplate rabbitTemplate;
	private String routekey;
	
	public Producter(RabbitTemplate rabbitTemplate, String routekey) {
		this.rabbitTemplate = rabbitTemplate;
		this.routekey = routekey;
	}
	
	public void sendMessage(String message) {
		rabbitTemplate.convertAndSend(routekey, message);
	}
}
