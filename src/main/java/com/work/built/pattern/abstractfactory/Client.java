package com.work.built.pattern.abstractfactory;

public class Client {

	public static void main(String[] args) {
		ComputerEngineer cf = new ComputerEngineer();
		AbstractFactory af = new AmdFactory();// IntelFactory();
		cf.makeComputer(af);
	}
}
