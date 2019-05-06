package com.rabbitmq.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbitmq.producter.Producter;

public class TopicsTest {
	
	//通配符模式测试
	public static void main(String[] args) {
		AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("spring-rabbitmq-topics.xml");
		Producter routingProducter = ctx.getBean(Producter.class);
		String message = "spring rabit topics hello!";
		routingProducter.sendMessage(message);
		ctx.close();
	}
}
