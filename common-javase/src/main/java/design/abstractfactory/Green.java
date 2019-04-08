package design.abstractfactory;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/8 14:04
 */
public class Green  implements  Color {
    @Override
    public void fill() {
        System.out.println("绿色填充");
    }
}
