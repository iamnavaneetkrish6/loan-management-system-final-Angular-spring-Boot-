package com.hexaware.loanmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDetailsDTO {

	private long customerId;
	@NotBlank(message = "Customer name is required")
	@Size(min = 2, max = 20, message = "Customer name must be between 2 and 50 characters")

	private String customerName;

	@NotBlank(message = "Customer Username is required")
	@Size(min = 5, max = 15, message = "Customer Username must be between 5 and 15 characters")
	private String customerUsername;

	@NotBlank(message = "Customer password is required")
	// @Pattern(regexp
	// ="^(?=.*[a-z])(?=.*[A-Z])(?=.*//d)(?=.*[!@#$%^&*_=+-]).{8,16}$")
	private String customerPassword;

	@NotBlank(message = "Customer address is required")
	@Size(min = 2, max = 30, message = "customer address must be between 2 and 50 characters")
	private String customerAddress;

	@NotBlank(message = "Customer state is required")
	@Size(min = 2, max = 15, message = "Customer state must be between 2 and 50 characters")
	private String customerState;

	@NotBlank(message = "Customer country is required")
	@Size(min = 2, max = 15, message = "Customer country must be between 2 and 15 characters")
	private String customerCountry;

	@Email(message = "Invalid email format")
	private String customerEmailId;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

}