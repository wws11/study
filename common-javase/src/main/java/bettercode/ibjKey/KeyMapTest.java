package bettercode.ibjKey;

import common.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/23 10:09
 */
public class KeyMapTest {


    public static void main(String[] args) {

        Map<Person,Integer>   map=new HashMap<>();


        Person person = new Person("张三", 12);
        Person person2 = new Person("张三", 12);

        map.put(person,11);
        map.put(person2,12);
        Integer integer = map.get(person);
        System.out.println(integer);
        System.out.println(map.get(person2));

    }
}
