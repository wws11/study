package enumtest;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 11:27
 */
public class EnumSetMap {

    public static void main(String[] args) {
        //EnumSet的使用
        EnumSet<Type> types = EnumSet.allOf(Type.class);
        for (Type type:types) {
            System.out.println(type);
        }
        //EnumMap的使用
        EnumMap<Type, Object> enumMap = new EnumMap<>(Type.class);
        enumMap.put(Type.FRI,"周五");
        enumMap.put(Type.MON,"周一");
        enumMap.put(Type.SUN,"周日");


    }
}
