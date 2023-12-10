package com.hexaware.loanmanagementsystem.dto;


public class AuthRequest {

	private String username;
	private String password;

	public AuthRequest() {
		super();
	}

	public AuthRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
