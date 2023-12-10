package com.hexaware.loanmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerAccountDetailsDTO {

	private long accountDetailsId;
	@NotBlank(message = "CustomerName is required")
	private String name;
	@NotNull
	private long accountNumber;
	@NotBlank(message = "Bank Name is required")
	private String bankName;
	@NotBlank(message = "Pancard Number  is required")
	private String panCardNumber;
	@NotNull
	private long aadharNumber;

	

	public CustomerAccountDetailsDTO() {

		super();

	}

	public long getAccountDetailsId() {
		return accountDetailsId;
	}

	public void setAccountDetailsId(long accountDetailsId) {
		this.accountDetailsId = accountDetailsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}



	

}
