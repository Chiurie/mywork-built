package com.work.built.pattern.abstractfactory;

public class AmdFactory implements AbstractFactory{

	private int pinsAndHoles = 938;
	
	public Cpu createCpu() {
		return new AmdCpu(pinsAndHoles);
	}

	public Mainboard createMainboard() {
		return new AmdMainboard(pinsAndHoles);
	}

}
