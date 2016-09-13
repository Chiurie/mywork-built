package com.work.built.pattern.abstractfactory;

public class AmdMainboard implements Mainboard{

	/**
	 * CPU ��� ����
	 */
	private int cpuHoles = 0;
	
	public AmdMainboard(int cpuHoles){
		this.cpuHoles = cpuHoles;
	}
	
	
	public void installCPU() {
		System.out.println("AMD�����CPU��ۿ����ǣ�" + cpuHoles);
	}
}
