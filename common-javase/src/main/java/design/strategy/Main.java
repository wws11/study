package design.strategy;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/26 9:17
 */
public class Main {

   private  static Map<String,Strategy> map =new HashMap<>();
    static {
        map.put("A",new StrategyA());
        map.put("B",new StrategyB());
    }
    public static void main(String[] args) {
        //使用map来存放策略
        for(Map.Entry<String,Strategy> entry:map.entrySet()){
            StrategyContext context = new StrategyContext(entry.getValue());
            context.doStrategry("hello");
        }
    }

}
