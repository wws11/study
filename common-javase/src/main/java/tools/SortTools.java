package tools;

import common.Person;

import java.lang.reflect.Field;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SortTools {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Person person = new Person();
        person.setAge(12);
        person.setName("埃菲尔");
        Person person1 = new Person();
        person1.setName("香港大哥");
        person1.setAge(13);
        Person person2 = new Person();
        person2.setAge(2243);
        person2.setName("张无忌");

        List<Person> people = new ArrayList<>();
        people.add(person2);
        people.add(person);
        people.add(person1);
        System.out.println("排序之前");
        people.forEach(e->{
            System.out.println(e);
        });
        List<Person> name = sortListByField(Person.class, people, "name");
        System.out.println("排序以后");
        name.forEach(e->{
            System.out.println(e);
        });


    }

    /**
     * 得到一个按照字母集合中实例对象按照某个字段中文排序的新集合
     *
     * @param clazz
     * @param list
     * @param field
     * @param <T>
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static <T> List<T> sortListByField(Class<T> clazz, List<T> list, String field) throws NoSuchFieldException, IllegalAccessException {
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }
        List<String> fieldValues = new ArrayList<>();
        //得到某个属性的集合
        for (T s : list) {
            Class<?> aClass = s.getClass();
            Field declaredField = aClass.getDeclaredField(field);
            declaredField.setAccessible(true);
            String value = (String) declaredField.get(s);
            fieldValues.add(value);
        }

        //对属性进行排序
        Collections.sort(fieldValues, Collator.getInstance(Locale.CHINA));
        //根据得到的字段有序集合，将集合进行排序
        List<T> newList = new ArrayList<>();
        for (String s : fieldValues) {
            if (s != null) {
                for (T t : list) {
                    Field declaredField = t.getClass().getDeclaredField(field);
                    declaredField.setAccessible(true);
                    String sourceField = (String) declaredField.get(t);
                    if (s.equals(sourceField)) {
                        newList.add(t);
                    }
                }
            }
        }
        return newList;
    }





}
