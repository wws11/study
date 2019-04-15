package juc.waitsleep;

;

import org.junit.Test;


import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/27 18:07
 */
public class WaitTest {


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (WaitTest.class) {
                    System.out.println("进入了线程1");
                }


            }
        });

    }


    @Test
    public void test1() throws InterruptedException {

      /*  ThreadPoolExecutor executor=new ThreadPoolExecutor(6,10,60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1000),
                new ThreadPoolExecutor.DiscardPolicy());


        executor.execute(new TaskA());*/

        final Object obj = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                try {
                    obj.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        Thread.sleep(1000);
        obj.notify();
    }

    /**
     *  执行上面代码时   java.lang.IllegalMonitorStateException
     *  解释：wait  和notify/notifyall 只能在同步代码块里用
     *
     *  将上面那你的代码改成下面的代码
     */

    @Test
    public   void  test2() throws InterruptedException {
        final Object obj = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                try {
                    synchronized (obj){
                        obj.wait();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        Thread.sleep(3000);
        synchronized (obj){
            System.out.println("开始唤醒");
            obj.notify();
            System.out.println("唤醒结束");
        }

    }

    @Test
    public  void  testLockSupport() throws InterruptedException {

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                LockSupport.park();
                System.out.println(sum);
            }
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
       // Thread.sleep(1000);   使用lock support不需要靠考虑计算的结果会处于挂起状态
        //wait如果先执行到notify的时候，wait还没有执行，所以程序挂起了，locksupport可以理解为 等到 LockSupport.park()执行完了再去执行LockSupport.unpark(A);
        //最大特点灵活啊啊啊 啊啊

        LockSupport.unpark(A);
    }

    //体现了locksupport的灵活性，不需要加在同步锁块里面

    @Test
    public  void testBlock() throws InterruptedException {
        final Object obj = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                try {
                    synchronized (obj){
                        obj.wait();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        //Thread.sleep(1000);
        /**
         * 如果不睡眠的话会导致下面的代码先执行，notify先执行了，导致上面的计算一直处于等待状态。
         * 但是使用locksupport不会出现这种情况
         */
        synchronized (obj){
            System.out.println("开始唤醒");
            obj.notify();
            System.out.println("唤醒结束");
        }
    }


    /**
     * 总结：
     * ①LockSupport不需要在同步代码块里 。所以线程间也不需要维护一个共享的同步对象了，实现了线程间的解耦。
     *
     * ②unpark函数可以先于park调用，所以不需要担心线程间的执行的先后顺序。
     */
}






