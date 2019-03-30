package juc.waitsleep;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/29 10:58
 */
public class TaskA  implements  Runnable {
    final Object obj = new Object();
    @Override
    public void run() {


        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        try {
            obj.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sum);
        try {
            System.out.println("进入休眠");
            Thread.sleep(2000);
            System.out.println("休眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
