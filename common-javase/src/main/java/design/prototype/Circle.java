package design.prototype;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/16 9:01
 */
public class Circle extends   Shape {
    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
