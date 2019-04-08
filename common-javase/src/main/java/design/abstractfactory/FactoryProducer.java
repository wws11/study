package design.abstractfactory;

/**
 * @Description   工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:11
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
