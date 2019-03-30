package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/27 17:16
 */
public class Envent1  implements   Runnable {

    //事件1



    @Override
    public void run() {

        System.out.println("开始做第一件事情");
    }
}
