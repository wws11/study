package bettercode;

/**
 * @Description   Effective Java  测试
 * @Author DJZ-WWS
 * @Date 2019/2/28 14:38
 */
public class CodeTest {


    public static void main(String[] args) {


        System.out.println(  valueOf(1==1));
    }


    //使用静态工厂方法代替构造器   这个工厂不代表设计模式的工厂模式不一个概念
    public  static   Boolean valueOf(boolean b){
        return  b ?Boolean.TRUE:Boolean.FALSE;
    }
    /**
     * 静态工厂方法代替构造器
     */

}
