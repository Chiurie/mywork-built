package com.work.built.pattern.staticfactory;

public class PasswordLogin implements Login{

	public boolean verify(String name, String password) {
		System.out.println("PasswordLogin==>verify():"+name+":"+password);
		return true;
	}

}
