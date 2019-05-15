package juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/14 16:44
 */
public class Mutex  implements Lock {

    //使用AQS实现锁
    private   static   class Sync extends AbstractQueuedLongSynchronizer{
        //是否处于占用状态

        protected Sync() {
            super();
        }

        @Override
        protected boolean tryAcquire(long arg) {
            return super.tryAcquire(arg);
        }

        @Override
        protected boolean tryRelease(long arg) {
            return super.tryRelease(arg);
        }

        @Override
        protected long tryAcquireShared(long arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(long arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return super.isHeldExclusively();
        }
    }
    @Override
    public void lock() {

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
