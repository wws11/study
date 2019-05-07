package com.gysoft.spring.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description  BeanProcessor类
 * @Author DJZ-WWS
 * @Date 2019/4/16 17:12
 */
public class BeanProcessor  implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(o instanceof  SpringBean){
            System.out.println("springbean被实例化之前");
        }
        if(o instanceof  Other){
            System.out.println("Other 实例化之前");
        }
        System.out.println("bean初始化之前执行 ,postProcessBeforeInitialization,BeanPostProcessor -->" + ",object:" + o + ",string:" + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(o instanceof  SpringBean){
            System.out.println("springbean被实例化之后");
        }
        if(o instanceof Other){
            System.out.println("Other 被实例化了");
        }
        System.out.println("bean初始化之后执行 ,postProcessAfterInitialization,BeanPostProcessor -->" + ",object:" + o + ",string:" + s);
        return o;
    }

}
