package design.decorator;

/**  装饰模式客户端调用代码，装饰的过程更像是层层包装，用前面的对象装饰后面的对象
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/9 19:11
 */
public class DecoratorClient {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();
        ConcreteDecoratorC concreteDecoratorC = new ConcreteDecoratorC();


        /**
         * 这里模拟画一幅画，从最开始的什么都没有，到最后的成为一副完美的画
         * 多态：编译看父类，执行看子类
         */
        concreteDecoratorA.setComponent(concreteComponent);
        concreteDecoratorB.setComponent(concreteDecoratorA);
        concreteDecoratorC.setComponent(concreteDecoratorB);
        concreteDecoratorC.operation();
    }
}
