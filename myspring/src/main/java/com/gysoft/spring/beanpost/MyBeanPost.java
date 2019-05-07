package com.gysoft.spring.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/6 20:49
 */
public class MyBeanPost  implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof  OneBean){
            System.out.println("赋值之前"+bean);
          ((OneBean) bean).setName("哈哈");
            System.out.println(bean);
        }
        System.out.println("bean 的后置处理器postProcessBeforeInitialization方法"+ "beanName"+  "开始初始化");
       //这里一定要返回bean，不能返回null
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof  OneBean){
            ((OneBean) bean).setAge(12);
        }
        System.out.println("postProcessAfterInitialization方法里"+bean);
        System.out.println("bean的后置处理器  postProcessAfterInitialization方法"+beanName+"完成初始化");
        return bean;
    }
}
