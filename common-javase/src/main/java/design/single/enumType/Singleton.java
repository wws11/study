package design.single.enumType;

/**
 * Create by wws on 2019/2/28
 */
public enum Singleton  implements MySingleton {

    /**
     * 一个单例枚举对象
     */
    INSTANCE;
//隐藏了一个默认的空参私有化构造器,枚举类的field其实是相应的enum类型的一个实例对象
    //对于一个标准的Enum单例模式，最优秀的写法还是实现接口的形式

    @Override
    public void doSomething() {
        System.out.println("做点什么好呢");
    }

    public static MySingleton  getInstance(){
        return Singleton.INSTANCE;
    }

}
