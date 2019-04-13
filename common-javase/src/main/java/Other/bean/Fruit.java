package Other.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description  蔬菜类 水果父类  测试泛型bean
 * @Author DJZ-WWS
 * @Date 2019/4/8 17:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {


    private   String name;
    private    String color;
    private   String sean;

    public static void main(String[] args) {

        Fruit fruit = new Fruit();


    }
}
