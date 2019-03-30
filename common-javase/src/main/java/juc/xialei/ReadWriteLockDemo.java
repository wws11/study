package juc.xialei;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyQueue
{
	
	
	private Object obj;

	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	
	public void readObj()
	{
		rwLock.readLock().lock();
		try {
			
			System.out.println(Thread.currentThread().getName()+"\t"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			rwLock.readLock().unlock();
		}
		
	}
	
	public void writeObj(Object obj)
	{
		rwLock.writeLock().lock();
		try {
			this.obj=obj;
			
			System.out.println(Thread.currentThread().getName()+"\t"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwLock.writeLock().unlock();
		}
		
	}
	
}

/**
 * 
 * @Description: 一个线程写入,100个线程读取
 * @author xialei
 * 
 */
public class ReadWriteLockDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		MyQueue myQueue= new MyQueue();
	
		new Thread(() -> {
			myQueue.writeObj("hello0529");
		}, "AA").start();
		
		for (int i =1; i <=100; i++) {
			
			new Thread(() -> {
				myQueue.readObj();
			},String.valueOf(i) ).start();
		}
		
	}
}
