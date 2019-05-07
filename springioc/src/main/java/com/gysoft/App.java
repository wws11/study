package com.gysoft;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/7 9:02
 */
public class App {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("ioc.xml");
        OneBean oneBean = (OneBean) app.getBean("oneBean");
        System.out.println(oneBean);
    }
}
