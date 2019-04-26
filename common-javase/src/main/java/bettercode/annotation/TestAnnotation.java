package bettercode.annotation;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/22 20:44
 */
public class TestAnnotation {

    public static void main(String[] args) {
        System.out.println("hello");
        //获取注解所有的值
        Method[] methods = LogImpl.class.getDeclaredMethods();
        for (Method method:methods){

            LogParm annotation = method.getAnnotation(LogParm.class);
            if(annotation!=null){
                //获取注解所有的值
                String action = annotation.operationAction();
                String function = annotation.operationFunction();
                String mOdel = annotation.operationMOdel();
                System.out.println("方法名  ："+method.getName()+"动作："+action+"说明"+function+"操作模块"+mOdel);
            }

        }

    }

}
