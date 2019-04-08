package bettercode;

import common.Person;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/8 9:25
 */
public class CutIfElse {


    //   测试Function 函数式接口的使用
    @Test
    public void test1(){
        //减少 if else 判断
        /*int a = 1;
        if (a == 1) {

            return;
        } */

        //Function<T,R>     R apply(T t);    接受一个T返回一个R
        Map<Integer, Function<Integer,Person >> map=new HashMap<>();

        map.put(1,e->{
           Person person = new Person();
            person.setName("jdk8");
            person.setAge(14);
            System.out.println("测试function的加载时机");
            return  person;
        });
        //如果map没有被调用，那么里面的打印语句不会执行
        Person person = map.get(1).apply(1);//这么写没问题，可以被调用
    }

    /**
     * 测试Function
     */
    @Test
    public  void test2(){
        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;

        name.andThen(e -> e * e).apply(3);
        int value = name.andThen(square).apply(3);
        System.out.println("andThen value=" + value);


        int value2 = name.compose(square).apply(3);
        System.out.println("compose value2=" + value2);

        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("huohuo");
        System.out.println(identity);
    }

    /**
     * 测试 Supplier
     */

    @Test
    public  void  test3(){
        //  T get();  传什么值返回什么值
        Map<Integer, Supplier<Person>>  map=new HashMap<>();

        map.put(1,()->{
            Person person = new Person();
            person.setName("张三");
            person.setAge(34);
            return  person;
        });

        map.put(2,Person::new);
        //默认参数的设置
        System.out.println(map.get(2).get());//Person{name='null', age='0'}
        //不为空的返回
        System.out.println(map.get(1).get());
    }


    /**
     * 测试Consumer<T>接受T
     */
    @Test
    public  void  testConsumer(){

  /*      Consumer<Person> hello = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                person.setAge(14);
                person.setName("hello");
            }
        };*/
        System.out.println("测试consume");
        //void accept(T t);   接收一个参数没有返回值
        Map<Integer, Consumer<Person>>  map=new HashMap<>();
        map.put(1,e->{
            Person person = new Person();
            person.setAge(12);
            person.setName("consumer");
            System.out.println("我是没有返回值得Consume");
        });
    }
}
