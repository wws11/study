package com.gysoft.spring.springbean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**spring初始化的流程
 * 1.执行该对象的构造方法
 * 2.执行set参数注入方法
 * 3.执行BeanNameAware的实现方法获取bean的id
 * 4.执行BeanFactoryAware的实现方法获取bean的工厂
 * 5.执行BeanPostProcessor的postProcessBeforeInitialization处理方法
 * 6.执行InitializingBean的实现方法
 * 7.执行配置的init-method的指定方法
 * 8.执行BeanPostProcessor的postProcessAfterInitialization处理方法
 * 9.执行普通被调用的方法
 * 10.执行DisposableBean的实现方法
 * 11.执行配置的destory-method的指定方法
 *
 */
public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        SpringBean springBean = (SpringBean) context.getBean("springBean");
        springBean.myMethod();
        context.registerShutdownHook();


    }
}
