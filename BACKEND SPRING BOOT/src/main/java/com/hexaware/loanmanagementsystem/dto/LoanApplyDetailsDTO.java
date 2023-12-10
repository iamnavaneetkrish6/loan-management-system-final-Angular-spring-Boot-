package com.hexaware.loanmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;

public class LoanApplyDetailsDTO {

	private long loanNo;
	@NotBlank(message = "LoanType is required")
	private String loanTypeName;
	private double loanAmount;
	private String loanOrginationDate;
	@NotBlank(message = "property address  is required")
	private String propertyAddress;
	@NotBlank(message = "Customer name is required")
	private String customerName;
	private String loanStatus = "PENDING" ;
	

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public long getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(long loanNo) {
		this.loanNo = loanNo;
	}

	public String getLoanTypeName() {
		return loanTypeName;
	}

	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}



	

	public String getLoanOrginationDate() {
		return loanOrginationDate;
	}

	public void setLoanOrginationDate(String loanOrginationDate) {
		this.loanOrginationDate = loanOrginationDate;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



}
