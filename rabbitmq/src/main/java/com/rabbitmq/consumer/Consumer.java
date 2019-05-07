package com.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;

/**
 * 消费者
 * 实现 MessageListener或ChannelAwareMessageListener(需手动确认的实现此接口)
 */
public class Consumer implements MessageListener{


	@Resource
	RabbitTemplate rabbitTemplate;
	public void onMessage(Message message) {
		String msg = null;
		try {
			//做一个延时处理模拟耗费时间
			Thread.sleep(10000);
			msg = new String(message.getBody(),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("消费者1收到消息，即将打印消息");
		System.out.println("消费者1消费："+msg);



	}
}
