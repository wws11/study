package design.strategy;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/26 9:13
 */
public class StrategyA  implements   Strategy{


    @Override
    public void strategyInterface(String msg) {
        System.out.println(msg+"是策略A");
    }
}
