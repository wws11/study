package design.decorator;

/**
 * @Description  被装饰者
 * @Author DJZ-WWS
 * @Date 2019/5/9 19:09
 */
public class ConcreteComponent extends   Component {
    @Override
    public void operation() {
        System.out.println("最原始的模样什么都没有，啊好丑");
    }
}
