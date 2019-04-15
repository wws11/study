package test.basejava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/13 10:57
 */
public class TestFanXing {
    /**
     * 泛型的分类
     * 泛型方法  在public 与返回值之间加上<T,R>  这样数据类型才能保证任意的，只在参数里加上(List<Person> person)不能称作泛型方法只能说是用来泛型
     * 泛型接口
     * 泛型类
     */

    @Test
    public   void  test1(){
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        /**
         * 泛型只在编译阶段有效。
         */
        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("泛型测试，类型相同");
        }
    }
}
