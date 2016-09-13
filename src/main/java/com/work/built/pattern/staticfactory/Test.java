package com.work.built.pattern.staticfactory;


public class Test {
	
	
	public static void main(String[] args) {
		String  loginType = "passcode";
		String name = "zhangsan";
		String password = "123456";
		Login login = LoginFactory.factory(loginType);
		boolean bool = login.verify(name, password);
		System.out.println(bool);
		
	}
}
