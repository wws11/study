package test.sort.naturesort;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/11 20:54
 */
public class NatureSortTest {


    public static void main(String[] args) {
        TreeSet ts = new TreeSet();  //创建一个TreeSet的集合


        ts.add(new Student("lisi02", 22));//往集合添加元素

        ts.add(new Student("lisi007", 20));

        ts.add(new Student("lisi09", 19));

        ts.add(new Student("lisi08", 19));
        Iterator it = ts.iterator(); //初始化迭代器，遍历集合中的所有元素

        while (it.hasNext()) {

            Student stu = (Student) it.next();

            System.out.println(stu.getName() + "..." + stu.getAge());

        }


    }
}
