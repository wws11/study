package bettercode.innerClass;

/**
 * @Description  成员内部类
 *  成员内部类时依赖外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类对象，创建成员内部类的对象的一般方式如下：
 *
 *  成员内部类为什么可以无条件访问外部类呢？
 *  通过反编译的技术分析源码可知在底层实现的时候内部类构造器会默认加上一个外部类的引用，看着是无参构造器，本质上已经发生了改变
 *  编译以后生成的类文件名
 * @Author DJZ-WWS
 * @Date 2019/4/22 10:28
 */
public class Outter {
    private Inner inner = null;
    public Outter() {

    }

    public Inner getInnerInstance() {
        if(inner == null)
            inner = new Inner();
        return inner;
    }

    class Inner {
        public Inner() {

        }
    }

    public static void main(String[] args) {

        //第一种方式：
        Outter outter = new Outter();
        Outter.Inner inner = outter.new Inner();  //必须通过Outter对象来创建

        //第二种方式：
        Outter.Inner inner1 = outter.getInnerInstance();
    }
}
