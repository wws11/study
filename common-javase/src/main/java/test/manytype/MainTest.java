package test.manytype;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/27 16:40
 */
public class MainTest {


    public static void main(String[] args) {

/**
 * java多肽三个必要条件
 *
 * 子类继承父类
 * 重写父类方法
 * 向上，向下转型
 */



        Parent  parent=new Children();

        //编译看父类，运行看子类


        parent.run();


    }
}
