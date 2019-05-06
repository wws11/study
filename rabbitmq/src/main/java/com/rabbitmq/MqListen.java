package com.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/29 10:30
 */
@Component
public class MqListen  extends HttpServlet {

    @Resource
    RabbitTemplate rabbitTemplate;

    private Logger logger = LoggerFactory.getLogger(MqListen.class);


    @Override
    public void init() throws ServletException {


    }

   public   void  getMessage(Message message){

        rabbitTemplate.onMessage(message);
   }

}
