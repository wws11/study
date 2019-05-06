package bettercode.constractbuild;

/**
 * @Description  构建者测试
 * @Author DJZ-WWS
 * @Date 2019/5/5 9:42
 */
public class BuildTest {

    public static void main(String[] args) {
        /**
         * 注：new  Nutrition的时候会调用他的构造器，构造器含有BUild对象的参数，通过这种实例化的方式将外部类进行赋值
         */
        Nutritions builder = new Nutritions.Builder(240, 8).colories(100).sodium(35).carbohydrate(12).builder();
        System.out.println(builder);
    }

}
