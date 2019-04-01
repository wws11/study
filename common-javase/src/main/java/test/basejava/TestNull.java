package test.basejava;

import common.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/1 19:11
 */
public class TestNull {

    public static void main(String[] args) {

        List<Person>  list=new ArrayList<>();
        //map里面数据允许为空
        List<Integer> ages = list.stream().map(Person::getAge).collect(Collectors.toList());
        //
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Person::getName, Person::getAge));

    }
}

