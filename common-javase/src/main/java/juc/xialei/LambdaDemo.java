package juc.xialei;
@FunctionalInterface
interface Foo{
	
	
	public int add(int x, int y);
	
	default int div(int x, int y) {
		  return x/y;
		 }
	
	public static int sub(int x, int y){
		  return x-y;
		}

	
}



/**
 * 
 * @Description: Lambda Express-----> 函数式编程
 *拷贝小括号(形参列表)，写死右箭头 ->，落地大括号 {方法实现}
 * @author xialei
 */
public class LambdaDemo
{
	public static void main(String[] args)
	{
	/*	Foo foo = new Foo() {
			
			@Override
			public int add(int x, int y) {
				System.out.println("hello 0529");
				return x+y;
			}
		};*/
		
		Foo foo = (int x,int y)->{
			System.out.println("hello 0529");
			return x+y;
		};
		
		System.out.println(foo.add(10, 5));
		System.out.println(foo.div(10, 5));
		System.out.println(Foo.sub(10, 5));
	}
}






/*
 * 1	拷贝小括号(形参列表)，写死右箭头 ->，落地大括号 {方法实现}
 * 2	有且只有一个public方法@FunctionalInterface注解增强定义
 * 3	default方法默认实现
 * 4	静态方法实现

 **/

