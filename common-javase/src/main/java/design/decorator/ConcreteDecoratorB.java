package design.decorator;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/9 19:16
 */
class ConcreteDecoratorB extends Decorator {
    @Override
    public void operation() {
        super.operation();
        addedBehavior();

    }

    public void addedBehavior() {
        System.out.print(" 有点丑美化一下吧，擦点粉");
    }
}
