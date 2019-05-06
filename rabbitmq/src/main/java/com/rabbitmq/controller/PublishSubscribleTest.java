package com.rabbitmq.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbitmq.producter.Producter;

public class PublishSubscribleTest {
	//发布订阅模式测试
	public static void main(String[] args) {
		AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("spring-rabbitmq-publish_subscrible.xml");
		Producter routingProducter = ctx.getBean(Producter.class);
		String message = "spring rabit publish_subscrible hello!";
		routingProducter.sendMessage(message);
		ctx.close();
	}
}
