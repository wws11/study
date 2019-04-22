package bettercode.innerClass;

/**
 * @Description  局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。
 * @Author DJZ-WWS
 * @Date 2019/4/22 10:32
 */
class People{
    public People() {

    }
}

class Man{
    public Man(){

    }

    public People getWoman(){
        class Woman extends People{   //局部内部类
            int age =0;
        }
        return new Woman();
    }
}