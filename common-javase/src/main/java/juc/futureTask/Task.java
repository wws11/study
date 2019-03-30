package juc.futureTask;

import java.util.concurrent.Callable;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 20:34
 */
public class Task  implements Callable {
    @Override
    public Object call() throws Exception {

        System.out.println("进入 Task   我将要睡三秒");
        Thread.sleep(3000);
        System.out.println("睡醒了");

        return null;
    }
}
