package com.hexaware.loanmanagementsystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CustomerAccountDetails {

	@Id
	@SequenceGenerator(name="customer_account_seq",initialValue=100,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_account_seq")
	private long accountDetailsId;
	private String name;
	private long accountNumber;
	private String bankName;
	private String panCardNumber;
	private long aadharNumber;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customerAccountDetails")
	private CustomerDetails customerDetails;
	
	public CustomerAccountDetails() {

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
