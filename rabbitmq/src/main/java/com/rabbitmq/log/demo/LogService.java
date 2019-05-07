package com.rabbitmq.log.demo;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/6 14:28
 */
public class LogService {


    /**   写一个job  执行这个任务定时实现保存
     *
     * 这里选用  线程池里面的调度Schedule线程去实现
     * 保存日志
     */




    public   void  saveLog(Log log){
        System.out.println("插入日志bean，保存日志到数据库");
    }
}
