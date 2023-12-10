package com.hexaware.loanmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.loanmanagementsystem.entity.LoanType;


@Repository
public interface LoanTypesRepository extends JpaRepository<LoanType, Long> {

	public LoanType findByLoanTypeName(String loanTypeName);
	
}