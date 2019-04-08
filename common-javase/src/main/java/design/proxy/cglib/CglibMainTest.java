package design.proxy.cglib;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/8 16:07
 */
public class CglibMainTest {

    public static void main(String[] args) {
        // 生成 Cglib 代理类
        Engineer engineerProxy = (Engineer) CglibProxy.getProxy(new Engineer());
        // 调用相关方法
        engineerProxy.eat();
    }
}
