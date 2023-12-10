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
public class PropertyDetail {

	@Id
	@SequenceGenerator(name="property_seq",initialValue=300,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="property_seq")
	private long propertyId;
	private String propertyOwner;
	private String propertyAddress;
	private double propertyValue;

	@OneToOne(mappedBy = "propertyDetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private LoanApplyDetails loanApplyDetails;

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyOwner() {
		return propertyOwner;
	}

	public void setPropertyOwner(String propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public double getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public LoanApplyDetails getLoanApplyDetails() {
		return loanApplyDetails;
	}

	public void setLoanApplyDetails(LoanApplyDetails loanApplyDetails) {
		this.loanApplyDetails = loanApplyDetails;
	}

	public PropertyDetail() {

		super();
	}

}
