package design.single;

/**
 * @Description   在jdk1.5之前  通过public  final 属性获取单例的对象
 * @Author DJZ-WWS
 * @Date 2019/5/4 15:56
 */
public class Elvis {

    public static final Elvis instance = new Elvis();

    private Elvis() {
        //私有化构造器
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.instance;
        Elvis elvis2 = Elvis.instance;
        System.out.println(elvis==elvis2);//true
    }

}
