package com.work.built.pattern.staticfactory;

public class LoginFactory {

	
	public static Login factory(String type){
		
		if(LoginType.domain.getDbValue().equals(type)){
		
			return new DomainLogin();
			
		}else if(LoginType.passcode.getDbValue().equals(type)){
			
			return new PasswordLogin();
		
		}else{
			
			throw new RuntimeException("没有找到登陆类型");
		
		}
	}
}
