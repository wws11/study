package com.gysoft.spring.beanpost;

import lombok.Data;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/6 20:52
 */

@Data
public class OneBean {


    private String name;
    private int age;
    private String email;

    public OneBean() {
        System.out.println("调用了无参构造器");
    }


    public OneBean(String name) {
        this.name = name;
        System.out.println("调用了有参构造器");
    }

    public   void  doSomeThing(){
        System.out.println("OneBean的 doSomeThing方法");
    }
}
