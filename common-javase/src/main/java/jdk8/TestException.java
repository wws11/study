package jdk8;

import common.Person;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/15 19:35
 */
public class TestException {


    //测试lambda抛出异常
    @Test
    public void test1() throws NoSuchFieldException {


        List<Person> list=new ArrayList();
        list.add(new Person("张开始看",123));
        list.add(new Person("师傅尽快吧",24));
        list.forEach(LambdaExceptionUtil.rethrowConsumer(e->{
            File file = new File("");
            //使用异常处理，解决lambda不能抛出异常的限制
            Field declaredField = e.getClass().getDeclaredField("");
        }));
    }
}
