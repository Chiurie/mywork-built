package com.work.built.thread.test.restaurant;

public class WaitPerson implements Runnable{

	private Restaurant restaurant;

	public WaitPerson(Restaurant r){
		restaurant = r;
	}
	
	public void run() {
		try{
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal != null) {
						wait();//。。。for the chef to produce a meal  
					}
				}
				System.out.println("Waitpeson got "+restaurant.meal);
				synchronized (restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}
				
			}
		}catch(InterruptedException e){
			System.out.println("Waitpeson interrupted");
		}
		
	}
	
	
	
}
