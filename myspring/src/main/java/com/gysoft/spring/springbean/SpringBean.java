package com.gysoft.spring.springbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import java.util.*;

/**
 * BeanNameAware 可以获得bean id值
 * BeanFactoryAware 可以获得bean工厂
 * InitializingBean(耦合性高)(注解 @PostConstruct)  类似于init-method 但是在init-method之前执行
 * DisposableBean(耦合性高)（注解 @PreDestroy） 类似于destory-method 但是在destory-method之前执行
 */
public class SpringBean implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String value;
    private int num;
    private Map<String, String> map;
    private Set<String> set;
    private String[] strs;
    private List<String> list;
    private Properties pros;

    public SpringBean() {
        System.out.println("无参构造方法的执行");
    }

    public SpringBean(String value) {
        this.value = value;
        System.out.println("有参构造方法的执行");
    }

    public void myMethod(){
        System.out.println("调用普通方法执行");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        System.out.println("set方法被执行");
        this.num = num;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }

    public void initMethod() {
        System.out.println("初始化bean的时候执行,顺序在InitializingBean实现方法后，init-method");
    }

    public void destoryMethod() {
        System.out.println("销毁bean的时候执行,顺序在DisposableBean实现方法后，destory-method");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("初始化的时候可以注入 bean工厂，需要实现BeanFactoryAware -->" + beanFactory);
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("初始化的时候可以注入 bean的id，需要实现BeanNameAware -->" + s);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化bean的时候执行 @PostConstruct，需要实现InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁bean的时候执行 @PreDestroy，需要实现DisposableBean");
    }

    @Override
    public String toString() {
        return "SpringBean{" +
                "value='" + value + '\'' +
                ", num=" + num +
                ", map=" + map +
                ", set=" + set +
                ", strs=" + Arrays.toString(strs) +
                ", list=" + list +
                ", pros=" + pros +
                '}';
    }
}
