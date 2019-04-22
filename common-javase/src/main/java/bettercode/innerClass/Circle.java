package bettercode.innerClass;

/**
 * @Description  成员内部类
 * 语法：
 * 成员内部类
 *
 *      内部类访问外部类可以任意去访问
 *     外部类访问方式  先创建内部类对象 在进行访问
 *     当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问
 *              外部类.this.成员变量
 *              外部类.this.成员方法
 *
 *
 * @Author DJZ-WWS
 * @Date 2019/4/22 10:16
 */
public class Circle {
    private double radius = 0;

    public Circle(double radius) {
        this.radius = radius;
        getDrawInstance().drawSahpe();   //必须先创建成员内部类的对象，再进行访问
    }

    private Draw getDrawInstance() {
        return new Draw();
    }

    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
        }
    }

    public static void main(String[] args) {


        Circle circle = new Circle(324);
        circle.getDrawInstance().drawSahpe();
    }

}
