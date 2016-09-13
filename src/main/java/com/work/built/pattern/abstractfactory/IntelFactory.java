package com.work.built.pattern.abstractfactory;

public class IntelFactory implements AbstractFactory{

	private int pinsAndHoles = 755;
	
	public Cpu createCpu() {
		return new IntelCpu(pinsAndHoles);
	}

	public Mainboard createMainboard() {
		return new IntelMainboard(pinsAndHoles);
	}

}
