package test.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        start1.setUnitAttrName("哈哈");
        start1.setUnitName("弟弟");
        Start start2 = new Start();
        start2.setUnitAttrName("啦啦");
        start2.setUnitName("哦哦");
        Start start3 = new Start();
        start3.setUnitAttrName("嗷嗷");
        start3.setUnitName("奥");
        List<Start> starts=new ArrayList<>();
        starts.add(start2);
        starts.add(start);
        starts.add(start3);
        starts.add(start1);


        System.out.println("没有排序之前:");
        starts.forEach(e->{
            System.out.println(e);
        });

        System.out.println("排序之后");

        Collections.sort(starts, new Comparator<Start>() {
            @Override
            public int compare(Start o1, Start o2) {
                //按照单位属性
                int flag=o2.getUnitAttrName().compareTo(o1.getUnitAttrName());
                //按照单位名
                if(flag==0){
                    o2.getUnitName().compareTo(o1.getUnitName());
                }
                return flag;
            }
        });
        starts.forEach(e->{
            System.out.println(e);
        });


    }
}
