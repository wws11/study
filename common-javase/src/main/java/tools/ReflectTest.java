package tools;

import common.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/13 13:00
 */
public class ReflectTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();

        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[1].setAccessible(true);
            System.out.println(declaredFields[i]);
        }

        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(personClass.newInstance()));

    }


    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        Person person1 = new Person("多个人", 12);
        Person person2 = new Person("发顺丰", 23);


        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        for (Person p : personList) {
            Class<? extends Person> aClass = p.getClass();
            Person per = aClass.newInstance();
            Field nameField = aClass.getDeclaredField("name");
            nameField.setAccessible(true);
            String nameValue = (String) nameField.get(per);
            System.out.println(nameValue);
        }
    }


    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setName("abel");
        person.setAge(16);

        Person person2 = new Person();
        person2.setName("abel2");
        person2.setAge(17);

        personList.add(person);
        personList.add(person2);
        List<String> names = getStringAbel(personList, Person.class, "name");

        names.forEach(e -> {
            System.out.println(e);
        });

    }

    @Test
    public void test3() {


    }


    public static List<String> getStringAbel(List<?> o, Class<?> c, String field) {
        List<String> nameList = new ArrayList<>();
        StringBuffer result = new StringBuffer();
        if (StringUtils.isNoneBlank(field)) {
            Field[] fields = c.getDeclaredFields();
            int pos;
            for (pos = 0; pos < fields.length; pos++) {
                if (field.equals(fields[pos].getName())) {
                    break;
                }
            }
            for (Object o1 : o) {
                try {
                    fields[pos].setAccessible(true);
                    nameList.add((String) fields[pos].get(o1));
                    //esult.append(fields[pos].get(o1) + ",");
                } catch (Exception e) {
                    System.out.println("error--------" + "Reason is:" + e.getMessage());
                }
            }
        }
        return nameList;
    }

}
