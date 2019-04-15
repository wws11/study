/*
package tools;

import common.Person;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

*/
/**
 * @Description  排序的工具类
 * @Author DJZ-WWS
 * @Date 2019/4/13 9:31
 *//*

public class ListSort {

public static  <T> List<T>  convertByABCSort(Class<T> clazz, List<T>  needConvertObj, String  sortType) throws Exception {

    List<T> list = new ArrayList<>();

    //通过反射获取T类型的字段
    //需要排序的某个字段
    */
/*List<String> names = new ArrayList<>();
    for (T t : needConvertObj) {
        Field declaredField = clazz.getDeclaredField(sortType);
        Method getName = clazz.getDeclaredMethod("getName");
        String name  = (String) getName.invoke(clazz.newInstance());
        declaredField.setAccessible(true);
        //String name = (String) declaredField.get(clazz.newInstance());
        System.out.println("反射获取的值     "+name);
      //  names.add(name);

    }*//*

*/
/*
    List<String> names = getStringAbel(needConvertObj, clazz, sortType);
    //对需要转换排序的字段进行中文排序
    Collections.sort(names, Collator.getInstance(java.util.Locale.CHINA));
    names.forEach(e -> {
        needConvertObj.forEach(e2 -> {
            //获得e2的属性值
            try {
                T o = (T) e2.getClass().newInstance();


            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
            if (e.equals(name)) {
                try {
                    T t = clazz.newInstance();
                    BeanUtils.copyProperties(e2, t);
                    list.add(t);
                    System.out.println("------");
                } catch (InstantiationException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
                }

            }
        });
    });
    return list;

}*//*


    public static void main(String[] args) throws Exception {

    List<Person>  personList=new ArrayList<>();
        personList.add(new Person("张三",12));
        personList.add(new Person("李四",1));
        personList.add(new Person("王无",13));
        personList.add(new Person("爱新觉罗",456));
        List<Person> personList1 = ListSort.convertByABCSort(Person.class, personList, "name");


        personList1.forEach(e->{
            System.out.println(e);
        });

    }

    public static List<String> getStringAbel(List<?> o, Class<?> c, String field) {
        List<String >  nameList=new ArrayList<>();
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

*/
