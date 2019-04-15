package design.proxy.jdkDymic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 定义一个处理器
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:53
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 因为需要处理真实角色，所以要把真实角色传进来
     * 处理谁
     */
    Subject realSubject;

    public MyInvocationHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类");
        if (method.getName().equals("sellBooks")) {
            int invoke = (int) method.invoke(realSubject, args);
            System.out.println("调用读书的sell方法");
            return invoke;
        } else if(method.getName().equals("speak")){

            String string = (String) method.invoke(realSubject, args);
            System.out.println("调用的是说话的方法");
            return string;
        } else if(method.getName().equals("earnMony")) {
                int mony= (int) method.invoke(realSubject,args);
            System.out.println("挣钱了");
            return   mony;
        }
            return null;
    }
}
