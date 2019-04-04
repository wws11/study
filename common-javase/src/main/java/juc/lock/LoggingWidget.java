package juc.lock;

/**
 * @Description   可重入锁的父类
 * @Author DJZ-WWS
 * @Date 2019/4/4 16:20
 */
public class LoggingWidget  extends Widget {

    @Override
    public  synchronized void  doSomeThing(){

        System.out.println("子类锁");
        super.doSomeThing();
        System.out.println("子类调用父类的方法，测试锁的可重入性");


    }

}
