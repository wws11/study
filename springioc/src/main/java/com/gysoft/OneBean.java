package com.gysoft;

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
        System.out.println("无参构造器");
    }


    public OneBean(String name) {
        this.name = name;
        System.out.println("有参构造器");
    }
}
