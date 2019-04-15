package design.proxy.jdkDymic;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:51
 */
public class RealSubject   implements Subject{
    @Override
    public int sellBooks() {
        System.out.println("卖书");
        return 1 ;
    }

    @Override
    public String speak() {
        System.out.println("说话");
        return "张三";
    }

    @Override
    public int earnMony() {
        return 10;
    }
}
