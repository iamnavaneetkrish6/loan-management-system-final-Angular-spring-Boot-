package com.hexaware.loanmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.loanmanagementsystem.entity.CustomerAccountDetails;


@Repository
public interface CustomerAccountDetailsRepository extends JpaRepository<CustomerAccountDetails, Long> {

	
	public CustomerAccountDetails findByName(String name);
}
