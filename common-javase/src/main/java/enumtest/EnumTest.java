package enumtest;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 10:37
 */
public class EnumTest {

    public static void main(String[] args) {

        System.out.println("枚举的值是"+Type.TUE.getValue());
        Type.TUE.setValue(34);
        System.out.println("枚举值的设置"+Type.TUE.getValue());
        System.out.println("第二次使用"+  Type.TUE.getValue());

        for(Type type:Type.values()){
            System.out.println(type.toString());
        }



        Type type = Type.TUE;
        switch (type){
          //  MON, TUE, WED, THU, FRI, SAT, SUN;
            case MON:
                System.out.println("今天周一");
           break;
            case TUE:
                System.out.println("今天周二");
        break;
            case THU:
                System.out.println("今天周三");
                break;
            case WED:
                System.out.println("今天周四");
                break;
            case FRI:
                System.out.println("今天周五");
                break;
            case SAT:
                System.out.println("今天周六");
                break;
            case SUN:
                System.out.println("今天周末了");
                break;
                default:
                    System.out.println("今天到底是哪一天");
        }



    }
}
