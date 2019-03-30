package juc.futureTask;

import juc.threadpool.ThreadPoolExecutorFactory;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 20:35
 */
public class TaskTest {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = ThreadPoolExecutorFactory.getThreadPoolExecutor();
        Task task = new Task();
        FutureTask futureTask = new FutureTask(task);
        executor.execute(futureTask);
        System.out.println(Thread.currentThread().getName()+"main");

    }

}
