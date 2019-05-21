package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description 自定义一个独占锁
 * @Author DJZ-WWS
 * @Date 2019/5/14 16:44
 */
public class Mutex implements Lock {


    //静态内部类，自定义同步组件
    private static class Sync extends AbstractQueuedLongSynchronizer {
        protected Sync() {


        }

        /**
         * 当状态为0的时候获取锁
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(long arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 释放锁，将状态设置为0
         *
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(long arg) {
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 是否处于占用状态
         *
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
