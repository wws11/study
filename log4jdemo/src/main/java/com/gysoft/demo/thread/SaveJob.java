package com.gysoft.demo.thread;

/**
 * @Description  这个任务用来定时是实现日志的保存
 * @Author DJZ-WWS
 * @Date 2019/5/7 19:18
 */
public class SaveJob   implements   Runnable{

    public void run() {
        System.out.println("开始执行日志的保存");

    }
}
