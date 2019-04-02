package com.gysoft.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/29 14:50
 */
@Component
public class MyBeanFactory  implements BeanFactoryPostProcessor {
    //这个接口只调用一次
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Iterator<String> iterator = configurableListableBeanFactory.getBeanNamesIterator();
        Car beanSelf = (Car) configurableListableBeanFactory.getBean("car");
       System.out.println("beanFactoryPostProcessor");

    }
}
