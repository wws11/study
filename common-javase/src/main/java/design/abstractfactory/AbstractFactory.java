package design.abstractfactory;

/**
 * @Description   ApprovealEnum 和 Shape 对象创建抽象类来获取工厂
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:05
 */
public abstract class AbstractFactory {

    public  abstract  Color getColor(String color);
    public  abstract  Shape  getShape(String  shape);

}
