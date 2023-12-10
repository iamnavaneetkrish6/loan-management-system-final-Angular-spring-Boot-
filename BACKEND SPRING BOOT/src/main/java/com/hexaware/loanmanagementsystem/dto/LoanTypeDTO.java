package com.hexaware.loanmanagementsystem.dto;

public class LoanTypeDTO {

	private long loanTypeId;
	private String loanTypeName;
	private double loanInterestRate;
	private int loanTerm;
	private String loanDescription;
	private int loanManagementFees;

	public LoanTypeDTO() {

		super();
	}

	public long getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(long loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public String getLoanTypeName() {
		return loanTypeName;
	}

	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}

	public double getLoanInterestRate() {
		return loanInterestRate;
	}

	public void setLoanInterestRate(double loanInterestRate) {
		this.loanInterestRate = loanInterestRate;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public String getLoanDescription() {
		return loanDescription;
	}

	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}

	public int getLoanManagementFees() {
		return loanManagementFees;
	}

	public void setLoanManagementFees(int loanManagementFees) {
		this.loanManagementFees = loanManagementFees;
	}

}
