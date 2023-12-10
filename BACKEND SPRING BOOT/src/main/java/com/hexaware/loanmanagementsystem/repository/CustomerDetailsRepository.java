package com.hexaware.loanmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.loanmanagementsystem.entity.CustomerDetails;


@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

	public CustomerDetails findByCustomerName(String customerName);
	
	Optional<CustomerDetails>findByCustomerUsername(String customerUsername);
	public CustomerDetails findByCustomerUsernameAndCustomerPassword(String customerUsername, String customerPassword);
	
}
