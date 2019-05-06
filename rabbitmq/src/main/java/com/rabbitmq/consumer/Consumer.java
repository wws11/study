package com.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

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
			msg = new String(message.getBody(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("消费者1收到消息，即将打印消息");
		System.out.println("消费者1消费："+msg);



	}
}
