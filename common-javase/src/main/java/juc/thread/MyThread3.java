package juc.thread;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/14 20:41
 */
public class MyThread3  extends  Thread{
    @Override
    public void run(){
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("i am waiting but facing interruptexception now");
            }
        }
    }
}
