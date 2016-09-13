package com.work.built.pattern.abstractfactory;

public class AmdMainboard implements Mainboard{

	/**
	 * CPU 插槽 孔数
	 */
	private int cpuHoles = 0;
	
	public AmdMainboard(int cpuHoles){
		this.cpuHoles = cpuHoles;
	}
	
	
	public void installCPU() {
		System.out.println("AMD主板的CPU插槽孔数是：" + cpuHoles);
	}
}
