package com.rabbitmq.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbitmq.producter.Producter;

//路由模式测试
public class RoutingTest {
	
	public static void main(String[] args) {
		AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("spring-rabbitmq-routing.xml");
		Producter routingProducter = ctx.getBean(Producter.class);
		String message = "spring rabit routing hello!";
		routingProducter.sendMessage(message);
		ctx.close();
	}
}
