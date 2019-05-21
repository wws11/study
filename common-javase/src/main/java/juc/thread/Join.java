package juc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/15 15:14
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            //在执行初始线程的时候由于privious的加入。调用了join方法，会优先执行这个加入的线程，直到这个加入的线程执行完毕，再继续执行另一个线程
            thread.start();
            previous=thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+"terminate");
    }

    static   class   Domino implements  Runnable{
        private   Thread thread;

        public  Domino(Thread thread){
            this.thread=thread;
        }
        @Override
        public void run() {

            try{
                thread.join();
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getName()+"terminate");
        }
    }
}
