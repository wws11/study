package com.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/29 9:12
 */

@Component
public class Consumer2  implements MessageListener {


    public void onMessage(Message message) {
        String mess=null;
        try {
          mess  = new String(message.getBody(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuffer  stringBuffer=new StringBuffer();
        stringBuffer.append(mess);
        System.out.println("消费者2收到消息");
        System.out.println(stringBuffer.toString());
    }
}
