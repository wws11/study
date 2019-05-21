package design.prototype;

/**
 * @Description  使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆
 * @Author DJZ-WWS
 * @Date 2019/5/16 9:03
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape circle1 = (Shape) ShapeCache.getShape("1");
        Shape circle2 = (Shape) ShapeCache.getShape("1");
        System.out.println(circle1.getId()==circle2.getId());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
