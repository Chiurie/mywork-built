package com.work.built.thread.car;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
	
	private Lock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	private boolean waxOn = false;
	
	public void waxed(){
		lock.lock();
		try {
			waxOn = true;
			condition.signalAll();
		}finally {
			lock.unlock();
		}
	}
	
	public void buffed(){
		lock.lock();
		try {
			waxOn = false;
			condition.signalAll();
		}finally{
			lock.unlock();
			
		}
		
	}
	

}
