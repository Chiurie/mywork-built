package com.work.built.thread.test.restaurant;

public class WaitPerson implements Runnable{

	private Restaurant restaurant;

	public WaitPerson(Restaurant r){
		restaurant = r;
	}
	
	public void run() {
		while (!Thread.interrupted()) {
			synchronized (this) {
			}
			
		}
		
	}
	
	
	
}
