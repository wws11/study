package juc.currnet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/13 16:09
 */
public class CountDown2 {


    public static void main(String[] args) throws Exception {


        CountDownLatch countDownLatch=new CountDownLatch(3);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i <3 ; i++) {
            Runnable runnable = () -> {
                System.out.println("线程"+Thread.currentThread().getName()+"创建");
                try {

                    System.out.println("每个线程开始做自己的任务");
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            };
           //提交任务
            service.execute(runnable);
        }
        System.out.println("dengdai");
        countDownLatch.await();
        System.out.println("三个线程任务完成");



    }
}
