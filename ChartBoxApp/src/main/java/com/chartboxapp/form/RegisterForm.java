package com.chartboxapp.form;

public class RegisterForm {
	private String name;
	private String email;
	private String Password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "RegisterForm [name=" + name + ", email=" + email + ", Password=" + Password + "]";
	}
	
	
	
}
