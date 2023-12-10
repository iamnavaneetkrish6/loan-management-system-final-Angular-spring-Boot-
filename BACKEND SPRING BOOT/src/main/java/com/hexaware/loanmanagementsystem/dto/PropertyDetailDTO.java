package com.hexaware.loanmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;

public class PropertyDetailDTO {

	private long propertyId;
	@NotBlank(message = "Property owner Name is required")
	private String propertyOwner;
	@NotBlank(message = "property address is required")
	private String propertyAddress;
	private double propertyValue;
	

	

	
	
	public PropertyDetailDTO() {
		super();
	}


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




	
	
	
}
