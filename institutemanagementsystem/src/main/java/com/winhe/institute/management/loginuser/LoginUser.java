package com.winhe.institute.management.loginuser;

public class LoginUser {

	private String email;
	private String password;
	
	public LoginUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public LoginUser() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
