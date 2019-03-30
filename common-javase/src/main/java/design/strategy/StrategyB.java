package design.strategy;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/26 9:14
 */
public  class StrategyB  implements   Strategy {

    @Override
    public void strategyInterface(String msg) {


        System.out.println(msg+"我是策略B");
    }
}
