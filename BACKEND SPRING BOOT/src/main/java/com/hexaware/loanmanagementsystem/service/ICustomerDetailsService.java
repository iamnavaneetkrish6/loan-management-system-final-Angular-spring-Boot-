package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import com.hexaware.loanmanagementsystem.dto.CustomerDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.CustomerDetails;



public interface ICustomerDetailsService {

	public CustomerDetails customerRegisteration(CustomerDetailsDTO customer);
	public CustomerDetails updateCustomerDetails(CustomerDetailsDTO customer, long id);
	
	public void deleteCustomer(long customerId);
	
	public CustomerDetails getCustomerDetailsById (long customerId);
	public List<CustomerDetails> getAllCustomerDetails();
	
}
