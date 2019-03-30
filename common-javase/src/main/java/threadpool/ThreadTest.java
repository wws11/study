package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/27 17:19
 */
public class ThreadTest
{
    public static void main(String[] args) throws InterruptedException {

        //定义两个任务

        CountDownLatch countDownLatch=new CountDownLatch(2);
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

        executor.submit(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程1");
                System.out.println(Thread.currentThread().getName()+"开始做事");
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }
        });


        executor.submit(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("线程2");
                System.out.println(Thread.currentThread().getName()+"开始做事");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }
        });

        //sleep不会释放锁，await会释放锁
            countDownLatch.await();
            //主线程等待上面两个线程结束后开始工作
        System.out.println("主线程的名字："+Thread.currentThread().getName()+"begin do someThing");


    }
}
