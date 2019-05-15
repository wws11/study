package juc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/15 10:37
 */
public class ShutDownThread {
    public static void main(String[] args) throws InterruptedException {

        Runner  one=new Runner();
        Thread countThread = new Thread(one, "countThread");
        countThread.start();
        //睡眠一秒，main线程对CountThread进行中断，是CountThread能够感知中断而结束。
        TimeUnit.SECONDS.sleep(1);

        countThread.interrupt();//设置线程的中断标记，运行的线程中断标记为false

        //另一个线程
        Runner two=new Runner();
        countThread= new Thread(two, "CountThread");
        countThread.start();
        //睡眠一秒，main线程对Runner two进行取消
        TimeUnit.SECONDS.sleep(1);

        //真正的关闭线程
       two.cancel();
    }
}
