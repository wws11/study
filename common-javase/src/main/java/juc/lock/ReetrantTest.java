package juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description  测试锁的可重入性
 * @Author DJZ-WWS
 * @Date 2019/4/4 16:13
 */
public class ReetrantTest {

int  a=0;
    ReentrantLock  lock=new ReentrantLock();
    public   void  writer(){
        //获取锁
        lock.lock();
        try{
        a++;
        }finally {
            //释放锁
            lock.unlock();
        }
    }

    public  void  read(){
        lock.lock();//获取锁
   try {
       int i=a;
       i++;
   }finally {
       lock.unlock();//释放锁
   }

;    }


}
