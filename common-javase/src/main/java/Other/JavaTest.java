package Other;

import common.LambdaExceptionUtil;
import common.Person;
import org.junit.Test;
;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/3/28 13:35
 */
public class JavaTest {


    @Test
    public  void testJavaBase() throws IllegalAccessException {

        //测试Java语法
        int  operation=3;
        if(!(operation==1||operation==0)){
            //不能使用operation!=1||operation!=0

            throw new  IllegalAccessException("操作类型错误");
        }

        System.out.println("没有进入异常");
   }


}
