package design.prototype;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/16 9:00
 */
public class Rectangle  extends   Shape {
    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

