package juc.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/14 20:00
 */
public class ThreadTest {


    /**
     * Terminated和NEW状态的线程对于java来说毫无意义，什么事也不会发生。
     * <p>
     * 测试线程的中断在new状态的时候中断标记
     */
    @Test
    public void testStart() {
        //处于就绪的状态
        Thread thread = new MyThread();
        System.out.println(thread.getState());//new
        thread.interrupt();
        System.out.println(thread.isInterrupted());  //false
    }

    /**
     * //TERMINATED表示线程已经终止
     *
     * @throws InterruptedException
     */
    @Test
    public void testTerminated() throws InterruptedException {

        Thread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println(thread.getState()); //TERMINATED
        thread.interrupt();
        System.out.println(thread.isInterrupted());  //false
    }

    /**
     * 如果线程处于运行状态，那么对于状态就是Runnable的状态，但是不是所有的Runnable状态都能获得CPU运行，
     * 在某个时间段，只能由一个线程占用cpu,那么其余的线程虽然状态是Runnable，但是都没有处于运行状态。
     * 而我们处于Runnable状态的线程在遭遇中断操作的时候只会设置该线程的中断标志位。
     * 处理的思路在run方法里加上判断，如果该线程被中断标记了，直接break。
     *
     * @throws InterruptedException
     */
    @Test
    public void testRUNNABLE() throws InterruptedException {
        Thread thread = new MyThread();
        thread.start();
        System.out.println(thread.getState()); //TERMINATED
        thread.interrupt();
        Thread.sleep(1000);//等到thread线程被中断之后
        System.out.println(thread.isInterrupted());//false
        System.out.println(thread.getState()); //再break循环以后状态变为TERMINATED

    }

    /**
     * 定义了两个线程并且按照定义的顺序启动他们，thread1启动后直接占用锁资源，thread2进入了队列，thread自然的处于阻塞状态，
     * 但是我们执行了中断操作，虽然thread2处于阻塞，中断标记为true，这样我们可以通过这个特性去灵活的处理
     * 测试线程处于阻塞状态时中断情况
     */
    @Test
    public void testBLOCKED() throws InterruptedException {

        Thread thread1 = new MyThread2();
        Thread thread2 = new MyThread2();


        thread1.start();
        thread2.start();

        Thread.sleep(2000);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        thread2.interrupt();//线程2中断
        System.out.println(thread2.isInterrupted());//true 线程虽然处于阻塞，但是还是true
        System.out.println(thread2.getState());//BLOCKED

    }

    /**
     * WAITING则是无限期等待，需要其他线程调用notify方法释放自己
     * TIMED_WAITING在等待一段时间后会自动释放自己
     * 这些线程在遇到中断的时候会抛出一个InterrruptedException,并清空中断标志位
     */
    @Test
    public void testWAITINGAndTIMED_WAITING() throws InterruptedException {
        Thread thread = new MyThread3();
        thread.start();

        Thread.sleep(500);
        System.out.println(thread.getState());//WAITING
        thread.interrupt();
        Thread.sleep(1000);
        System.out.println(thread.isInterrupted());//false
        System.out.println(thread.getState());//异常以后程序终止了
    }


    @Test
    public   void  testFianlly(){
Thread thread=      new  DaemonThread();
    thread.setDaemon(true);
    thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread= new  DaemonThread();
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(2000);
    }

    /**
     * 测试优雅的关闭线程
     */
    @Test
    public   void  testCloseRunner() throws InterruptedException {

        Runner  one=new Runner();
        Thread countThread = new Thread(one, "countThread");
        countThread.start();
        //睡眠一秒，main线程对CountThread进行中断，是CountThread能够感知中断而结束。
        TimeUnit.SECONDS.sleep(1);
      //计时一秒后线程已经跑了一秒，得到一个值，这时候进行中断，线程退出
    countThread.interrupt();//设置线程的中断标记，运行的线程中断标记为false
        /**
         * 开启另一个线程，线程通过开关去实现线程关闭，而不是仅仅通过中断状态去实现关闭线程
         */
        Runner two=new Runner();
        countThread= new Thread(two, "CountThread");
        countThread.start();
        //睡眠一秒，main线程对Runnable two进行取消
        TimeUnit.SECONDS.sleep(1);
        //优雅的关闭线程 two
        two.cancel();
    }
}
