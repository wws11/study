package com.gysoft.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/29 15:03
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {


    private String name;
    private int age;
    static {
        System.out.println("测试静态方法块--------------------------------");
    }

    public Car() {
        System.out.println("我是构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性" + "Name");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("注入属性" + "Age");
        this.age = age;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out
                .println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    // 通过<bean>的init-method属性指定的初始化方法  
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法  
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");

    }

}
