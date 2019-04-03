package juc.threadloal;

import org.junit.Test;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/3 16:02
 */
public class ThreadLocalMapTest {


    //jdk1.2以后就已经有了强引用，弱引用。软引用，虚引用

    /**
     * jdk1.2以后，引用就被分为四种类型：强引用、弱引用、软引用和虚引用。强引用就是我们常用的Object obj = new Object()，
     * obj就是一个强引用，指向了对象内存空间。当内存空间不足时，Java垃圾回收程序发现对象有一个强引用，宁愿抛出OutofMemory错误
     * ，也不会去回收一个强引用的内存空间。而弱引用，即WeakReference，意思就是当一个对象只有弱引用指向它时，垃圾回收器不管当
     * 前内存是否足够，都会进行回收。反过来说，这个对象是否要被垃圾回收掉，取决于是否有强引用指向。ThreadLocalMap这么做，
     * 是不想因为自己存储了ThreadLocal对象，而影响到它的垃圾回收，而是把这个主动权完全交给了调用方，一旦调用方不想使用，
     * 设置ThreadLocal对象为null，内存就可以被回收掉。
     *
     */



    @Test

    public  void  test1(){

        ThreadLocal   threadLocal=new ThreadLocal();
    }
}
