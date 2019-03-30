package juc.xialei;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class ShareData//资源类
{
	private int number = 0;//初始值为零的一个变量
	
	
	private Lock lock = new ReentrantLock();
	private Condition cd  = lock.newCondition(); 
	
	public   void increment() throws InterruptedException 
	{	
		
		lock.lock();
		try {
			
			//判断
			while (number!=0) {
				cd.await();
			}
			//干活
			++number;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			//通知
			cd.signalAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
		
	    
		
	}
	
	public void decrement() throws InterruptedException 
	{
		
		lock.lock();
		try {
			
			//判断
			while (number!=1) {
				cd.await();
			}
			//干活
			--number;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			//通知
			cd.signalAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
		
	}
}

/**
 * 
 * @Description:
 *现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来10轮。 
 * @author xialei
 *
 *  * 笔记：Java里面如何进行工程级别的多线程编写
 * 1	多线程编程模板（套路）-----上
 * 		1.1	线程		操作		资源类	
 * 		1.2	高内聚	低耦合
 * 2	多线程编程模板（套路）-----下
 * 		2.1	判断
 * 		2.2	干活
 * 		2.3	通知
 
 */
public class NotifyWaitDemo
{
	public static void main(String[] args)
	{
		
		ShareData shareData= new ShareData();
		new Thread(() -> {
			for (int i = 1; i <=10; i++) {
				try {
					shareData.increment();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "AA").start();
		
		new Thread(() -> {
			for (int i = 1; i <=10; i++) {
				try {
					shareData.decrement();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "BB").start();
		new Thread(() -> {
			for (int i = 1; i <=10; i++) {
				try {
					shareData.increment();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "CC").start();
		
		new Thread(() -> {
			for (int i = 1; i <=10; i++) {
				try {
					shareData.decrement();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "DD").start();
	}
}





/*
 * * 
 * 2	多线程变成模板（套路）-----下
 * 		2.1	判断
 * 		2.2	干活
 * 		2.3	通知
 * 3	防止虚假唤醒用while
 * 
 * 
 * */





