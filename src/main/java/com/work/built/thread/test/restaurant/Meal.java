package com.work.built.thread.test.restaurant;

public class Meal {

	private final int orderNum;
	
	private Meal(int orderNum){
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "Meal "+orderNum;
	}

}
