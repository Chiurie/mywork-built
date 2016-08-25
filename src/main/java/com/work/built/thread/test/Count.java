package com.work.built.thread.test;

import java.util.Random;

//计数器
public class Count {
	private int count = 0;
	private Random rand = new Random(47);
	
	public synchronized int increment(){
		int temp = count;
		if(rand.nextBoolean())
			Thread.yield();
		return (count = ++ temp);
			
	}
	public synchronized int value(){
		return count;
	}
	
}
