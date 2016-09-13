package com.work.built.pattern.abstractfactory;

public class IntelCpu implements Cpu{

	private int pins = 0;
	
	public IntelCpu(int pins){
		this.pins = pins;
	}

	public void calaulate() {
		
		System.out.println("Intel CPUµÄÕë½ÅÊı£º" + pins);
	}
	
}
