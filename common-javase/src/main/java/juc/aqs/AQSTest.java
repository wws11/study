package juc.aqs;

/**
 * @Description  测试自定义锁
 * @Author DJZ-WWS
 * @Date 2019/3/29 13:41
 */
public class AQSTest {


    public static void main(String[] args) throws InterruptedException {


        Mutex mutex=new Mutex();

        new  Thread(() -> System.out.println("线程1开始跑")).start();
        new  Thread(() -> System.out.println("线程2开始跑")).start();

        mutex.lock();
        String name = Thread.currentThread().getName();
        Thread.sleep(3000);
        System.out.println("我被锁住了"+name);
        mutex.unlock();
        System.out.println("解锁了");

    }

}
