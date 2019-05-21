package design.prototype;

import java.util.Hashtable;

/**
 * @Description   创建一个类，从数据库获取实体类，并他们存储在一个HashTable中
 * @Author DJZ-WWS
 * @Date 2019/5/16 9:02
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap
            = new Hashtable();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
