package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import com.hexaware.loanmanagementsystem.dto.CustomerAccountDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.CustomerAccountDetails;

public interface ICustomerAccountDetailsService {

	public CustomerAccountDetails createCustomerAccountDetails(CustomerAccountDetailsDTO customerAccountDetails);
	public CustomerAccountDetails updateCustomerAccountDetails(CustomerAccountDetailsDTO customerAccountDetails,long id);
	
	public void deleteCustomerAccountDetails(long customerAccountDetailsID);
	
	public CustomerAccountDetails getCustomerAccountDetailsByCustomerId(long customerID);
	
	public List<CustomerAccountDetails> getAllCustomerAccountDetails();
	
	
}
