package juc.currnet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 该程序用来模拟发送命令与执行命令，主线程代表指挥官，新建3个线程代表战士，战士一直等待着指挥官下达命令，
 * *若指挥官没有下达命令，则战士们都必须等待。一旦命令下达，战士们都去执行自己的任务，指挥官处于等待状态，战士们任务执行完毕则报告给
 * @Author DJZ-WWS
 * @Date 2019/4/13 15:25
 */
public class CountDownLatchTest {


    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        //模拟命令
        CountDownLatch cdOrder = new CountDownLatch(1);
        //模拟战士，多个线程

        CountDownLatch answer = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //战士待命状态
                        System.out.println("线程" + Thread.currentThread().getName() + "正在准备待命");
                       //个人理解，到目前为止还没有向线程池提交任务，等待的线程为主xianc
                        cdOrder.await();
                        System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "回应命令处理结果");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        answer.countDown();
                    }
                }
            };
            service.execute(runnable);//为线程池添加任务

        }

        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
            cdOrder.countDown(); //发送命令，cdOrder减1，处于等待的战士们停止等待转去执行任务。
            System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");
            answer.await(); //命令发送后指挥官处于等待状态，一旦cdAnswer为0时停止等待继续往下执行
            System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        service.shutdown(); //任务结束，停止线程池的所有线程
    }

}

