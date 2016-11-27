package com.chartboxapp.dto;

public class LoginDTO {
	
	private String emailID;
	private String password;
	
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		return "EmailID =: "+emailID+"  password =: "+password ;
	}
	
}
