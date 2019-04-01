package test.manytype;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/27 16:37
 */
public class Children  extends   Parent {


    public Children() {
        System.out.println("父类无参构造器");
    }


    static{
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类普通代码块");
    }

    private   String   career;

        public  void playCpmputeGanme(){
            System.out.println("子类玩电脑游戏");
        }

        @Override
        public void run(){
            System.out.println("子类的run方法");
        }
}
