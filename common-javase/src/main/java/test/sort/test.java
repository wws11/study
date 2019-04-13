package test.sort;


import org.junit.Test;

import java.util.TreeSet;

public class test {
	public static void main(String[] args) {
		method();
	}
	public static void method(){
		//测试定制排序
		Fruit f1 = new Fruit("pear",6);
		Fruit f2 = new Fruit("apple",5);
		Fruit f3 = new Fruit("banana",10);
		Fruit f4 = new Fruit("watermelon",2);
		Fruit f5 = new Fruit("banana",1);
		
		TreeSet set1 = new TreeSet(new Mycomparator());
		set1.add(f1);
		set1.add(f2);
		set1.add(f3);
		set1.add(f4);
		set1.add(f5);
		
		for (Object object : set1) {
			System.out.println(object);
		}
	}

	//测试自然排序
	@Test
	public  void test2(){



	}

}




