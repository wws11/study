package juc.lock;

/**
 * @Description  测试锁的可重入性
 * @Author DJZ-WWS
 * @Date 2019/4/4 16:13
 */
public class ReetrantTest {


    public static void main(String[] args) {

        Widget widget = new Widget();
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomeThing();

    }

}
