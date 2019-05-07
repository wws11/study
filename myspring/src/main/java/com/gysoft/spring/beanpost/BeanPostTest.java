package com.gysoft.spring.beanpost;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/6 21:02
 */
public class BeanPostTest {


    public static void main(String[] args) {


        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("beanpost.xml");
        OneBean oneBean = app.getBean("oneBean", OneBean.class);
        System.out.println(oneBean);

    }
}
