package juc.lock;

/**
 * @Description  可重入锁的子类
 * @Author DJZ-WWS
 * @Date 2019/4/4 16:14
 */
public class Widget {


    public synchronized void  doSomeThing(){

        System.out.println("父类的锁方法");

    }
}
