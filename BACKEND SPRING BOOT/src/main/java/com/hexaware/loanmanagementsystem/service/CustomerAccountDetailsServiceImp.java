package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.loanmanagementsystem.dto.CustomerAccountDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.CustomerAccountDetails;
import com.hexaware.loanmanagementsystem.exception.CustomerAccountDetailsNotFoundException;
import com.hexaware.loanmanagementsystem.repository.CustomerAccountDetailsRepository;

@Service
public class CustomerAccountDetailsServiceImp implements ICustomerAccountDetailsService {

	@Autowired
	private CustomerAccountDetailsRepository customerAccountDetailRepository;

	Logger logger = LoggerFactory.getLogger(CustomerAccountDetailsServiceImp.class);

	@Override
	public CustomerAccountDetails createCustomerAccountDetails(CustomerAccountDetailsDTO customerAccountDetails) {

		CustomerAccountDetails customerAccountDetail = new CustomerAccountDetails();
		customerAccountDetail.setAccountNumber(customerAccountDetails.getAccountNumber());
		customerAccountDetail.setName(customerAccountDetails.getName());
		customerAccountDetail.setBankName(customerAccountDetails.getBankName());
		customerAccountDetail.setPanCardNumber(customerAccountDetails.getPanCardNumber());
		customerAccountDetail.setAadharNumber(customerAccountDetails.getAadharNumber());

		return customerAccountDetailRepository.save(customerAccountDetail);

	}

	@Override
	public CustomerAccountDetails updateCustomerAccountDetails(CustomerAccountDetailsDTO customerAccountDetails, long id) {

		CustomerAccountDetails customerAccountDetail = customerAccountDetailRepository.findById(id).orElseThrow(() -> new CustomerAccountDetailsNotFoundException(HttpStatus.NOT_FOUND,
				"No Customer account details linked with customer Id " + id + " found"));
		customerAccountDetail.setAccountDetailsId(customerAccountDetails.getAccountDetailsId());
		customerAccountDetail.setAccountNumber(customerAccountDetails.getAccountNumber());
		customerAccountDetail.setName(customerAccountDetails.getName());
		customerAccountDetail.setBankName(customerAccountDetails.getBankName());
		customerAccountDetail.setPanCardNumber(customerAccountDetails.getPanCardNumber());
		customerAccountDetail.setAadharNumber(customerAccountDetails.getAadharNumber());

		return customerAccountDetailRepository.save(customerAccountDetail);
	}

	@Override
	public void deleteCustomerAccountDetails(long customerAccountDetailsID) {
	    customerAccountDetailRepository.deleteById(customerAccountDetailsID);
	}

	@Override
	public CustomerAccountDetails getCustomerAccountDetailsByCustomerId(long customerID) {

		return customerAccountDetailRepository.findById(customerID)
				.orElseThrow(() -> new CustomerAccountDetailsNotFoundException(HttpStatus.NOT_FOUND,
						"No Customer account details linked with customer Id " + customerID + " found"));
	}

	@Override
	public List<CustomerAccountDetails> getAllCustomerAccountDetails() {

		List<CustomerAccountDetails> customerAccountDetails = customerAccountDetailRepository.findAll();

		if (customerAccountDetails.isEmpty()) {
			throw new CustomerAccountDetailsNotFoundException(HttpStatus.NOT_FOUND,
					"Customer Account details not found");
		}

		return customerAccountDetails;
	}

}