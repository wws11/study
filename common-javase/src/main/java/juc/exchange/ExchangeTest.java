package juc.exchange;


import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;

/**
 * @Description   juc工具类交换机测试
 * @Author DJZ-WWS
 * @Date 2019/3/29 12:45
 */
public class ExchangeTest  extends  Thread {

    private Exchanger<String> exchanger;
    private String string;
    private String threadName;

    public ExchangeTest(Exchanger<String> exchanger, String string,
                         String threadName) {
        this.exchanger = exchanger;
        this.string = string;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + ": " + exchanger.exchange(string));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangeTest test1 = new ExchangeTest(exchanger, "string1",
                "thread-1");
        ExchangeTest test2 = new ExchangeTest(exchanger, "string2",
                "thread-2");
        ExchangeTest test3 = new ExchangeTest(exchanger, "string3", "thread-3");


        test1.start();
       // test2.start();
        test3.start();
        //此时程序的运行结果是不确定的，多次运行可以发现，配对结果可能是test1和test3交换，也可能是test1和test2交换，
        // 而剩下的未得到配对的线程，
        // 则会被阻塞，永久等待，直到与之配对的线程到达位置，对于本程序，则只能强制将其停止。

        /**
         * 这个程序创建了两个线程，线程执行过程中，调用同一个exchange对象的exchange的方法，进行信息通讯，
         * 当两个线程均已经将信息存到exchange对象中，exchange对象会将两个线程放入的信息交换，然后返回。
         *
         * 执行结果如下
         *
         * thread-1: string2
         * thread-2: string1
         *
         * 另外需要注意的是，Exchanger类仅可用作两个线程的信息交换，当超过两个线程调用同一个exchanger对象时，得到的结果是随机的，
         * exchanger对象仅关心其包含的两个“格子”是否已被填充数据，当两个格子都填充数据完成时，该对象就认为线程之间已经配对成功，
         * 然后开始执行数据交换操作
         *
         */
    }

    @Test
    public  void  test1(){
//注意，这个线程类不能使用这个单元测试去测试，会报错



    }

}
