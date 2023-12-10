package com.hexaware.loanmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.loanmanagementsystem.entity.LoanApplyDetails;


@Repository
public interface LoanApplyDetailsRepository extends JpaRepository<LoanApplyDetails, Long> {

	public List <LoanApplyDetails> findByCustomerName(String customerName); 
	
}
