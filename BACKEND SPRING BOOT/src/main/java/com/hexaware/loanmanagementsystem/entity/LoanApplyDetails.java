package com.hexaware.loanmanagementsystem.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LoanApplyDetails {

	@Id
	@SequenceGenerator(name = "loan_seq", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_seq")
	private long loanNo;
	private String loanTypeName;
	private double loanAmount;
	private String loanOrginationDate;
	private String propertyAddress;
	private String customerName;
	private String loanStatus = "PENDING";


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_ID")
	private CustomerDetails customerDetails;

	public PropertyDetail getPropertyDetail() {
		return propertyDetail;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	
	
	
	public String getLoanOrginationDate() {
		return loanOrginationDate;
	}

	public void setLoanOrginationDate(String loanOrginationDate) {
		this.loanOrginationDate = loanOrginationDate;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public void setPropertyDetail(PropertyDetail propertyDetail) {
		this.propertyDetail = propertyDetail;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loanType_ID")
	private LoanType loanType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PropertyDetails_ID")
	private PropertyDetail propertyDetail;

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

	public LoanType getLoantype() {
		return loanType;
	}

	public void setLoantype(LoanType loantype) {
		this.loanType = loantype;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
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

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

}
