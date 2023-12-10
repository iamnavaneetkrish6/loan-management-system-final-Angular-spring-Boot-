package com.hexaware.loanmanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CustomerDetails {

	@Id
	@SequenceGenerator(name="customer_seq",initialValue=1000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_seq")
	private long customerId;
	private String customerName;
	private String customerUsername;
	private String customerPassword;
	private String customerAddress;
	private String customerState;
	private String customerCountry;
	private String customerEmailId;
	private final String roles="ROLE_USER";

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CustomerAccountDetails_ID")
	private CustomerAccountDetails customerAccountDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerDetails", fetch = FetchType.LAZY)
	private List<LoanApplyDetails> loanApplyDetails = new ArrayList<>();


	public CustomerAccountDetails getCustomerAccountDetails() {
		return customerAccountDetails;
	}

	public void setCustomerAccountDetails(CustomerAccountDetails customerAccountDetails) {
		this.customerAccountDetails = customerAccountDetails;
	}

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

	public List<LoanApplyDetails> getLoanApplyDetails() {
		return loanApplyDetails;
	}

	public void setLoanApplyDetails(List<LoanApplyDetails> loanApplyDetails) {
		this.loanApplyDetails = loanApplyDetails;
	}


	public String getRoles() {
		return roles;
	}

	
	
}
