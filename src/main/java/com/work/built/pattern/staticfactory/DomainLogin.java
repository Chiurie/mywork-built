package com.work.built.pattern.staticfactory;


public class DomainLogin implements Login{

	public boolean verify(String name, String password) {
		System.out.println("DomainLogin==>verify()"+name+":"+password);
		return false;
	}
}
