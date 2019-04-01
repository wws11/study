package test.manytype;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/27 16:35
 */


public class Parent {


private  String name;

private   Integer age;


    public Parent() {
        System.out.println("父类无参构造器");
    }


    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("普通代码块");
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public   void run(){
        System.out.println("父类的跑方法");
    }

    public void  eat(){


        System.out.println("父类的eat方法");
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
