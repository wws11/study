package juc.thread;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/15 10:17
 */
public class Runner  implements   Runnable {
    private   long i;
    private  volatile  boolean on=true;

    @Override
    public void run() {
        while (on&&!Thread.currentThread().isInterrupted()){
            i++;
        }
        System.out.println("Count i =" + i);
    }
    //优雅的关闭线程的方法
    public  void   cancel(){
        on=false;
    }
}
