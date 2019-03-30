package design.single;

import design.single.enumType.MySingleton;
import design.single.enumType.Singleton;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 11:51
 */
public class SingleTest {


    public static void main(String[] args) {

        //测试使用枚举的方式单例模式
        MySingleton instance1 = Singleton.getInstance();
        MySingleton instance2 = Singleton.getInstance();
        System.out.println(instance1==instance2);

    }
}
