package juc.waitsleep;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/27 14:02
 */
public class TestSleep {

    public static void main(String[] args) {
    new  Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new  Thread(new Thread2()).start();
    }



   private static  class Thread1 implements   Runnable{

       @Override
       public void run() {
           synchronized (TestSleep.class){
               System.out.println("进入thread1");
               System.out.println("thread1进行等待");
               try {
                   TestSleep.class.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("thread1 继续执行");
               System.out.println("thread1  is over!!");

           }



       }
   }

   private static   class  Thread2 implements   Runnable{

       @Override
       public void run() {

           synchronized (TestSleep.class){
               System.out.println("进入thread2");
               System.out.println("thread2  is sleep...");
               System.out.println("调用了notify方法");
             // TestSleep.class.notify();//这个注释掉的话thread1会一直处于挂起
              //下面的sleep注释掉，thread2会同步运行不会等待
               try {
                   Thread.sleep(5000);
                   System.out.println(Thread.currentThread().getName());
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("thread2 is going");
               System.out.println("thread2 is over!!");
           }
       }
   }
}
