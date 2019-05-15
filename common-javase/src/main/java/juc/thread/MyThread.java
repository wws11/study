package juc.thread;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/14 19:59
 */
public class MyThread  extends   Thread {

    @Override
    public void run() {
        while(true){
            if (Thread.currentThread().isInterrupted()){
                //一旦线程被中断，立即退出死循环
                System.out.println("exit MyThread");
                break;
            }
        }
    }
}
