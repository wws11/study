package juc.demo.runnabletype;

/**
 * @Description   使用实现的方式实现龟兔赛跑
 * @Author DJZ-WWS
 * @Date 2019/4/4 9:50
 */
public class Rabbit extends Animal implements   Runnable{



    @Override
    public void run() {
        System.out.println("兔子开始跑");
        while (super.getLength()>0){
            Integer integer = super.getLength();

        }



    }
}
