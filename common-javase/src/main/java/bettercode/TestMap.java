package bettercode;

import common.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/29 8:46
 */
public class TestMap {

    public static void main(String[] args) {
        ArrayList<Person> persons= new ArrayList<>();
        Person person1 = new Person();
        person1.setName("fsf");
        person1.setCareer("fgd");
        Person person2 = new Person();
        person2.setName("fsfg");
        person2.setCareer("d");
        System.out.println(person2);
        persons.add(person1);
        persons.add(person2);
       // Map<String, String> collect = persons.stream().collect(Collectors.toMap(Person::getName,Person::getCareer));
        Map<String, String> collect = persons.stream().collect(HashMap::new,(k, v) ->k.put(v.getName(),v.getCareer()),HashMap::putAll);
        Map<String,String>  map=new HashMap<>();
        persons.forEach(e->{
            map.put(e.getName(),e.getCareer());
        });
    /*
        Map<String,String> map=new HashMap(){{
            put("fdsgs","dgdg");
            put("fsfsa","fsew");
            put("dgdgf","gre");
            put("fsd","");
            put("fsdsfas",null);
        }};*/
        for (Map.Entry entry:collect.entrySet()){
            System.out.println(entry.getKey()+" -----"+entry.getValue());
        }


        Person person = new Person();
    }






}
