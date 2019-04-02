package design.build.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description   测试动态代理
 * @Author DJZ-WWS
 * @Date 2019/4/2 9:43
 */
public class DynamicTest {

    public static void main(String[] args) {
        IGamePlayer gp = (IGamePlayer) new GamePlayer("张三");
        InvocationHandler gpHandler = new GamePlayerInvocationHandler(gp);
        //获取真实主题类的ClassLoader
        ClassLoader classLoader = gp.getClass().getClassLoader();
        //动态产生一个代理者。
        Class<?>[] cls = new Class[]{IGamePlayer.class};
        IGamePlayer proxyGp = (IGamePlayer) Proxy.newProxyInstance(classLoader, cls, gpHandler);
        proxyGp.login("zhangsan", "123456");
        proxyGp.killBoss();
        proxyGp.upGrade();
    }

}
