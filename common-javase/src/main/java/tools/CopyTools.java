package tools;

import common.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CopyTools {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person person = new Person("张三", 12);
        Person person1 = new Person();
        copyProperties(person,person1);
        System.out.println(person1);
    }


    public static <T,R> void  copyProperties(Object source,Object target) throws IllegalAccessException, InvocationTargetException {

        //获取source的所有属性
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        Field[] targetClassDeclaredFields = targetClass.getDeclaredFields();
        Field[] declaredFields = sourceClass.getDeclaredFields();
        for (int i = 0; i <declaredFields.length ; i++) {
            declaredFields[i].setAccessible(true);
            Object o = declaredFields[i].get(source);

            for (int j = 0; j <targetClassDeclaredFields.length ; j++) {
                //字段相等
                if(declaredFields[i].equals(targetClassDeclaredFields[j])){
                    //将属性值进行赋值
                    //获取set方法，进行赋值
                    Method[] methods = targetClass.getMethods();
                    for (int k = 0; k < methods.length; k++) {
                        //获取方法名
                        String name = methods[k].getName();
                    if(name.substring(0,2).equals(declaredFields[i])){
                        //执行invoke方法
                        methods[k].invoke(o,targetClass);
                    }
                    }


                }
            }
        }




    }
}
