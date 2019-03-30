package com.gysoft.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/29 14:14
 */
public class TestSpring {


    public static void main(String[] args) {

/*
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
        //将线程池注入  获取线程池对象*/

          /*  ctx.close();*/
/*
        ThreadPoolExecutorFactory executorFactory = ctx.getBean("executorFactory", ThreadPoolExecutorFactory.class);
        //获取线程池对象
        ThreadPoolExecutor threadPoolExecutor = ThreadPoolExecutorFactory.getThreadPoolExecutor();*/
        //spring生命周期接口测试
        System.out.println("容器现在开始启动");
        ApplicationContext factory = new ClassPathXmlApplicationContext("application.xml");
        System.out.println("容器初始化成功");
        Car car = (Car) factory.getBean("car");
        System.out.println(car);
        System.out.println("现在开始关闭容器");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }


}
