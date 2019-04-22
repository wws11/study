package bettercode.innerClass;


/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/22 11:09
 */
public class Sequence {


private   Object []  items;

private   int   next=0;
public   Sequence(int  size){
    items=new  Object[size];
}

public  void   add(Object  x){
    if(next<items.length)
        items[next++]=x;
}



}
