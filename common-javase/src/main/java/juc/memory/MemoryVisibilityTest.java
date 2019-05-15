package juc.memory;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/11 15:48
 */
public class MemoryVisibilityTest {



    public static void main(String[] args) {
          MyDate  myDate=new MyDate();
        //开启一个线程更改mydate的值
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myDate.setA();
                System.out.println("a的值被更改了，更改为  "+myDate.a);
            }
        });
        thread.setName("线程A");
        //开启线程
        thread.start();


        while (myDate.a==0){
            //如果线程跳过这句话，说明值已经被修改了，否则就是上个线程对值的修改main线程并不知道，还保持原来的值0
        }
        System.out.println("原始数据已经被修改");




    }
}
