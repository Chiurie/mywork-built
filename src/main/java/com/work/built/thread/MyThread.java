package com.work.built.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyThread {
	
	public static void main(String[] args) {
		//LiftOff launch = new LiftOff();
		//launch.run();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			/*Thread t = new Thread(new LiftOff());
			t.start();
			System.out.println(i+":"+"Waiting for LiftOff!");*/
			exec.execute(new LiftOff());
		}
		exec.shutdown();
		
	}

}
