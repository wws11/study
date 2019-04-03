package Other.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/2 17:32
 */
public class SortTest {


    public static void main(String[] args) {


        Start start = new Start();
        start.setUnitAttrName("中国");
        start.setUnitName("我");
        Start start1 = new Start();
        start.setUnitAttrName("哈哈");
        start.setUnitName("弟弟");
        Start start2 = new Start();
        start.setUnitAttrName("啦啦");
        start.setUnitName("哦哦");
        Start start3 = new Start();
        start.setUnitAttrName("嗷嗷");
        start.setUnitName("奥");
        List<Start> starts=new ArrayList<>();
        starts.add(start);
        starts.add(start1);
        starts.add(start2);
        starts.add(start3);
        System.out.println("没有排序之前:");
        starts.forEach(e->{
            System.out.println(e);
        });

        System.out.println("排序之后");

        Collections.sort(starts, (o1, o2) -> {
            //按照单位属性
            int flag=o1.getUnitAttrName().compareTo(o2.getUnitAttrName());//升序
            //按照单位名
            if(flag==0){
                o1.getUnitName().compareTo(o2.getUnitName());
            }
            return flag;
        });
        starts.forEach(e->{
            System.out.println(e);
        });


    }
}
