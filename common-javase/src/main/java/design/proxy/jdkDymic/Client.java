package design.proxy.jdkDymic;

import java.lang.reflect.Proxy;

/**
 * @Description   调用端
 * @Author DJZ-WWS
 * @Date 2019/4/8 15:18
 */
public class Client {


    public static void main(String[] args) {
        //真实对象
        Subject realSubject =  new RealSubject();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        //代理对象
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);

        System.out.println("代理对象"+proxyClass);
        proxyClass.sellBooks();

        proxyClass.speak();


    }
}
