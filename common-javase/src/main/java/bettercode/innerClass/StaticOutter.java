package bettercode.innerClass;

/**
 * @Description   静态内部类
 *
 * 静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法
 * @Author DJZ-WWS
 * @Date 2019/4/22 10:36
 */
public class StaticOutter {

    public StaticOutter() {

    }

    static class Inner {
        public Inner() {

        }
    }
}
