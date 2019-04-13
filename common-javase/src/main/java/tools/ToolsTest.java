package tools;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/9 11:39
 */
public class ToolsTest {


    @Test
    public void test1(){
        //测试时间
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 6);
        System.out.println(date.getTime());
    }

    @Test

    public void test2(){
        /*Date date = new Date();
        System.out.println(date);*/
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
      //  String format = simpleDateFormat.format("2019-04-04 11:21:36.0");
        //System.out.println(format);
    String  str="2019-04-04 11:21:36.0";
        String substring = str.substring(0, 10);
        System.out.println(substring);}


}
