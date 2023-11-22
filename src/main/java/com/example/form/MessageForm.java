package com.example.form;

public class MessageForm {
 
	private String message;
	private Integer loggedUserFlag;
	
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Integer getLoggedUserFlag() {
		return this.loggedUserFlag;
	}
	public void setLoggedUserFlag(Integer loggedUserFlag) {
		this.loggedUserFlag = loggedUserFlag;
	}
}