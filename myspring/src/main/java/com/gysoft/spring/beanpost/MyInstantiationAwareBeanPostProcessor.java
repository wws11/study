package com.gysoft.spring.beanpost;

import com.gysoft.spring.beanpost.proxy.CglibProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * @Description   这个借口主要作用在于目标对象的实例化过程中需要处理的事情，包括实例化前后过程中以及实例属性的设置
 *
 * 1、实例化—-实例化的过程是一个创建Bean的过程，即调用Bean的构造函数，单例的Bean放入单例池中
 *
 * 2、初始化—-初始化的过程是一个赋值的过程，即调用Bean的setter，设置Bean的属性
 *
 * @Author DJZ-WWS
 * @Date 2019/5/7 11:37
 */
public class MyInstantiationAwareBeanPostProcessor  implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {

        /**
         *  这个方法是最先执行的，它在目标对象实例化之前调用，返回的值是Object，我们可以返回任何类型的值。
         *  这个时候目标对象还没有被实例化，所以这个返回值可以用来代替原本该生成的目标对象的实例（比如代理对象）。
         *  如果该方法的返回值代替原本该生成的目标对象，后续只有postProcessorAfterInitialization方法会调用，其他方法不会再调用，否则按照正常的流程走
         */
        //在这里返回一个代理对象测试   使用cglib代理
        /*if(aClass== OneBean.class){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(aClass);
            enhancer.setCallback(new MyMethodInterceptor());
            OneBean proxy = (OneBean)enhancer.create();
            System.out.print("返回动态代理\n");
            return proxy;
        }*/
        /**
         * 当返回的是代理对象的时候，最后获得是代理对象，所以后面的对原本对象的实例化就没有必要执行，后面的对象的初始化就是对代理对象的初始化。
         */
        if(aClass==OneBean.class){
            Object proxy = CglibProxy.getProxy(new OneBean());
            return proxy;
        }
        System.out.println("实例化之前  postProcessBeforeInstantiation 方法调用"+s);

        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
        /**
         * 这个方法在目标方法实例化之后调用，这个时候目标对象已经被实例化，但是该实例的属性还没有被设置，都是null.
         *  它的返回值是决定要不要调用postProcessValues方法的其中一个因素（因为还有一个因素是mbd.getDependencyCheck())；
         *  如果该方法返回false，并且不需要check，那么postProcessPropertyValues就不会被忽略不执行，；如果返回true，postProcessPropertyValues就会被执行
          */
        System.out.println("实例化之后 postProcessAfterInstantiation 方法调用"+s);
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {

        /**
         * 这个方法对属性值的修改（这个时候属性值没有被设置，但是我们可以修改原本该设置进去的属性值）
         * 如果postProcessAfterInstantiation方法返回false,该方法可能不会被调用。可以在该方法内对属性值进行修改
         */
        System.out.println("调用 InstantiationAwareBeanPostProcessor  的  postProcessPropertyValues 方法");
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("初始化之前 postProcessBeforeInitialization 调用"+s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("初始化之后  postProcessAfterInitialization 方法调用"+s);
        return o;
    }
}
