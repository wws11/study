package test.basejava;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** 测试几种map性能问题
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/1 19:04
 */
public class TestMapIterator {


    @Test
    public void testMap() {

        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < 1000; i++) {
            map.put(i, "a"+i);
        }
        /*map.put(1, "a");
        map.put(2, "b");
        map.put(3, "ab");
        map.put(4, "ab");
        map.put(4, "ab");*/// 和上面相同 ， 会自己筛选
        System.out.println(map.size());
        // 第一种：
        /*
         * Set<Integer> set = map.keySet(); //得到所有key的集合
         *
         * for (Integer in : set) { String str = map.get(in);
         * System.out.println(in + "     " + str); }
         */
        System.out.println("第一种：通过Map.keySet遍历key和value：");
        long begin1 = System.currentTimeMillis();
        for (Integer in : map.keySet()) {
            //map.keySet()返回的是所有key的值
            String str = map.get(in);//得到每个key多对用value的值
           /* System.out.println(in + "     " + str);*/
        }
        long end1 = System.currentTimeMillis();
        System.out.println("第一种遍历方式耗时：-》"+(end1-begin1));




        // 第二种：
        System.out.println("第二种：通过Map.entrySet使用iterator遍历key和value：");
        long begin2 = System.currentTimeMillis();
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
           /* System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());*/
        }
        long end2 = System.currentTimeMillis();
        System.out.println("第二种遍历方式耗时：-》"+(end2-begin2));




        long begin3 = System.currentTimeMillis();
        System.out.println("第三种：通过Map.entrySet遍历key和value");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
         /*   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());*/
        }
        long end3 = System.currentTimeMillis();

        System.out.println("第三种遍历方式耗时：-》"+(end3-begin3));


        long begin4 = System.currentTimeMillis();
        // 第四种：
        System.out.println("第四种：通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
           /* System.out.println("value= " + v);*/
        }
        long end4 = System.currentTimeMillis();
        System.out.println("第四种遍历方式耗时：-》"+(end4-begin4));
    }


}
