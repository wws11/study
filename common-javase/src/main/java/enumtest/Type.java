package enumtest;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/2/28 9:09
 */
enum  Type {

    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);

//枚举类不允许有public 修饰的构造器

    /**
     *
     */
    private    Type(){

    }

    private  int  value;
    private   Type(int value){

        this.value=value;
    }


    public   int getValue(){
        return  value;
    }
    public   void setValue(int value){
        this.value=value;
    }



}
