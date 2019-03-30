package jdk8;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/8 8:46
 */
public class LambdaDo {


public  static     void   test(Fn  fn) throws Exception {

    Method get = fn.getClass().getMethod("get");

    get.setAccessible(true);

    Object invoke = get.invoke(fn);

    System.out.println(invoke);
}

}
