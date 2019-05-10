package design.decorator;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/9 19:16
 */
class ConcreteDecoratorA extends Decorator {

    @Override
    public void operation() {
        // 首先运行原Component的operation()，再执行本类的功能，如addedState，相当于对原Component进行了装饰
        /**
         * 在执行A的时候由于调用了super的方法   被装饰者的父类是Component  根据多肽的特性它会自己执行它自己本身的实现
         */
        super.operation();//执行被装饰者

        System.out.println("画个一般的脸吧");
    }
}