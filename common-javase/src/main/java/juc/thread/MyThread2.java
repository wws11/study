package juc.thread;

/**
 * @Description   测试线程处于阻塞状态时中断的情况
 * @Author DJZ-WWS
 * @Date 2019/5/14 20:23
 */
public class MyThread2   extends   Thread{

    public synchronized static void doSomething(){
        while(true){
            //do something
        }
    }
    @Override
    public void run() {

        doSomething();
    }
}
