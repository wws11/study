package design.single;

/**
 * @Description   jdk1.5 通过静态工厂的方式实现单例的创建
 * @Author DJZ-WWS
 * @Date 2019/5/4 15:50
 */
public class StaticFactorySingleTon {


    private   static   final   StaticFactorySingleTon  SINGLETON=new StaticFactorySingleTon();

    private   StaticFactorySingleTon(){

    }
    public static   StaticFactorySingleTon  getInstance(){
        return  SINGLETON;
    }

    public static void main(String[] args) {

        System.out.println(StaticFactorySingleTon.getInstance()==StaticFactorySingleTon.getInstance());//true
    }
    /**
     * 公有域方法 的好处在于，组成类的成员很清楚的表明了这个类是一个Singleton;公有域的静态域是final，所以该域将总是包含相同对象的引用。
     */
}
