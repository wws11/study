package design.single.staticinner;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 11:56
 */
public class Singleton {

public  static  class SingleHolder{
    private   static final  Singleton INSTANCE=new Singleton();
}

private   Singleton(){

}

    /**
     * 由于静态内部类SingletonHolder只有在getInstance()方法第一次被调用时，才会被加载，而且构造函数为private，因此该种方式实现了懒汉式的单例模式。不仅如此，根据JVM本身机制，静态内部类的加载已经实现了线程安全
     * @return
     */
    public  static final  Singleton getInstance(){
    return  SingleHolder.INSTANCE;
}
}
