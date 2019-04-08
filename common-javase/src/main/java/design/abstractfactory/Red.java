package design.abstractfactory;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:03
 */
public class Red  implements   Color {
    @Override
    public void fill() {
        System.out.println("填充红色");
    }
}
