package jdk8;


import common.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public  final class LamTest {


private  String  name;


    @Test
    public   void  test()
    {


        LamTest one=null;
       Optional.ofNullable(one).orElseGet(LamTest::new).testOption();
        //one.testOption();//空指针


        Person person = new Person();
        person=null;
        Optional.ofNullable(person).orElseGet(Person::new).getName();
    }


    public  void  testOption(){
        System.out.println("hah");

    }

    @Test
    public  void  testNUllPoint(){
/*
        Person person = new Person();


        person=null;
        //  person.setAge(11);
 List<Person> personList=new ArrayList<>();

         LambdaExceptionUtil.rethrowConsumer(
        Optional.ofNullable(person).map(Person::getAge).ifPresent(age -> {
            System.out.println(age);
        });


        Optional.ofNullable(person).ifPresent(e->{
            //消费型
            System.out.println("ifPresent:"+e.getAge());
            System.out.println("ifPresent:"+e.getName());
        });


        // person.print();   空指针
        Optional.ofNullable(person).orElseGet(Person::new);// 供给型*/
    }

    @Test
    public   void testMapValueNullPoint(){
        Map<String,Person> map=new HashMap<>();
        Person person = new Person();
        person=null;
        System.out.println(person);
        map.put("1",person);
        System.out.println(  map.get("1"));
        // map.get("1").print();   空指针

        Optional.ofNullable(map.get("1")).orElseGet(Person::new).print();   //没问题

        //list映射成map
        List<Person>   persons=new ArrayList<>();
        person.setAge(11);
        person.setName("tom");
        persons.add(person);
        Map<String, Person> namePersionMap = persons.stream().collect(Collectors.toMap(Person::getName, e -> e));

    }


    @Test
    public void  testFlatMap(){

        //java8的Optional flatmap   stream  map filter   distinck
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);


        // Let's print all players before Java 8
        List<String> listOfAllPlayers = new ArrayList<>();

        //将所有结合合成一个   传统做法
        for(List<String> team : playersInWorldCup2016){
            for(String name : team){
                listOfAllPlayers.add(name);
            }
        }

        //Java8之后操作
        List<String> allPlayerList = playersInWorldCup2016.stream().flatMap(pList -> pList.stream()).collect(Collectors.toList());
        System.out.println("所有的选手名字");
        allPlayerList.forEach(e->{
            System.out.println(e);

        });

    }


    @Test
    public  void testOptional(){



        LamTest one=null;
        Optional.ofNullable(one).orElseGet(LamTest::new).testOption();
        //one.testOption();//空指针


        Person person = new Person();
        person=null;
        String name = Optional.ofNullable(person).orElseGet(Person::new).getName();
        System.out.println("name"+name);
        //String s = Optional.ofNullable(person).orElseGet(Person::new).getName();


    }
}
