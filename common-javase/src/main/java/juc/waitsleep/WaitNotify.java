package juc.waitsleep;

/**
 * @Description   测试notify和wait机制
 * @Author DJZ-WWS
 * @Date 2019/5/15 11:44
 */
public class WaitNotify {
static  Object lock=new Object();
    static boolean flag=true;

    /**
     * 整个的一个执行流程wait线程先执行，执行到wait方法进行等待，进入等待队列，这时候释放锁，主线程休眠，
     * notify线程还没有开始进行工作，主线程休眠以后notify开始工作，由于wait已经将锁释放，所以notify会握住锁，
     * 执行了notify的业务以后将wait线程唤醒，这时候notify的业务还没有执行完，wait已经被唤醒，将进入阻塞队列，状态变为阻塞状态，
     * 后面notify进入二次加锁，等到这个里面的业务执行完以后，wait线程才能继续走后面的逻辑，从而将状态从阻塞变为运行
     *
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "waitThread");
        waitThread.start();
        Thread.sleep(3000);
        Thread notifyThread = new Thread(new Notify(), "notifyThread");

        notifyThread.start();
    }

    static   class Wait implements   Runnable{
        @Override
        public void run() {
            //当条件不满足时继续wait，同时释放了lock锁
            synchronized (lock){
                  while (flag){
                  try {
                      System.out.println(Thread.currentThread().getName()+" falg is true"+" wait 线程进入等待状态");
                      lock.wait();//执行以后线程变为阻塞状态
                      System.out.println("wait 被唤醒"+"线程的状态为"+Thread.currentThread().getState());
                  }catch (Exception e){
                      e.printStackTrace();
                  }
                  }
                  //条件满足时完成工作
                System.out.println(Thread.currentThread().getName()+" flag is false ");
            }
        }
    }

    static   class  Notify implements   Runnable{
        @Override
        public void run() {
            synchronized (lock){
                //获取lock的锁，然后进行通知，通知不会释放lock的锁
                //直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println("notify 握住了锁");
            lock.notifyAll();;
            flag=false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //再次加锁
            synchronized (lock){
                //这个地方测试线程不会立马从wait返回，而是需要等待notify或者notifyall的线程释放锁之后，等待线程才有机会从wait返回
                System.out.println(Thread.currentThread().getName()+" 再次得到一个锁");
                try {
                    System.out.println(Thread.currentThread().getName()+"我将要睡3秒");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"睡醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
