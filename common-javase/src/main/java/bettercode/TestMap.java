package bettercode;

import common.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/29 8:46
 */
public class TestMap {

    public static void main(String[] args) {

        Map<String,String> map=new HashMap(){{
            put("fdsgs","dgdg");
            put("fsfsa","fsew");
            put("dgdgf","gre");
        }};
        for (Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+" -----"+entry.getValue());
        }


        Person person = new Person();
    }

}
