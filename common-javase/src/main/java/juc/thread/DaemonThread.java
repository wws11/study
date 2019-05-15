package juc.thread;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/15 9:49
 */
public class DaemonThread  extends   Thread{
    @Override
    public void run() {
        try {
            System.out.println("执行到线程的任务了");
            throw new  NullPointerException("异常了，测试finally");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}
