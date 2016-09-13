package com.work.built.pattern.abstractfactory;

public class AmdCpu implements Cpu{

	private int pins = 0;
	
	public AmdCpu(int pins){
		this.pins = pins;
	}
	
	public void calaulate() {

		System.out.println("AMD CPUµÄÕë½ÅÊı£º" + pins);
	}
}
