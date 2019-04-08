package design.abstractfactory;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:05
 */
public class Blue  implements   Color {
    @Override
    public void fill() {
        System.out.println("蓝色填充");
    }
}
