package design.proxy.jdkDymic;

import java.lang.reflect.Proxy;

/**
 * 静态代理和动态代理的区别
 * 静态：手动创建的代理类，生成源码再对其编译，在程序运行前.class文件就已经存在
 * 动态： 在程序运行时运用反射机制动态创建而成。
 *
 * @Description 调用端
 * @Author DJZ-WWS
 * @Date 2019/4/8 15:18
 */
public class Client {


    public static void main(String[] args) {
        //System.out.println(System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true"));
        //真实对象
        Subject realSubject = new RealSubject();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        //代理对象
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);
//design.proxy.jdkDymic.RealSubject@7921b0a2
        System.out.println("代理对象" + proxyClass);
        proxyClass.sellBooks();
        proxyClass.speak();

    }
}
