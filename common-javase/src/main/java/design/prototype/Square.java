package design.prototype;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/16 9:00
 */
public class Square  extends Shape{
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
