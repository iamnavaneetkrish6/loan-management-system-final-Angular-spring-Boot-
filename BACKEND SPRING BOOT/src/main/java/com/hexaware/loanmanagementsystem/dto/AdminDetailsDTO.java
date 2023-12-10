package com.hexaware.loanmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AdminDetailsDTO {

	private long adminId;
    @NotBlank(message = "Admin name is required")
    @Size(min = 2, max = 50, message = "Admin name must be between 2 and 50 characters")
	private String adminName;
    @Email
    @NotBlank(message = "Admin email is required")
	private String emailId;
    @NotBlank(message = "Admin username is required")
    @Size(min = 6, max = 15, message = "Admin Username must be between 2 and 50 characters")
	private String adminUsername;
    @NotBlank(message = "Admin password is required")
    //@Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*//d)(?=.*[!@#$%^&*_=+-]).{8,16}$")
	private String password;
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
