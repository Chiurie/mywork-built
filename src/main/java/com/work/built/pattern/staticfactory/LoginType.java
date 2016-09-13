package com.work.built.pattern.staticfactory;

public enum LoginType {

	passcode("passcode", "账号密码登陆"), 
	domain("domain","域登陆"),
	phonecode("phonecode","手机验证码登陆");
	
	
	private String dbValue;
	private String msgKey;
	
	private LoginType(String dbValue, String msgKey){
		this.dbValue = dbValue;
		this.msgKey = msgKey;
	}
	public String getDbValue() {
		return dbValue;
	}
	public void setDbValue(String dbValue) {
		this.dbValue = dbValue;
	}
	public String getMsgKey() {
		return msgKey;
	}
	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}
}
