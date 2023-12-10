package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import com.hexaware.loanmanagementsystem.dto.LoanTypeDTO;
import com.hexaware.loanmanagementsystem.entity.LoanType;



public interface ILoanTypesService {

	
	public LoanType createLoanType(LoanTypeDTO loanType);
	public LoanType updateLoanType(LoanTypeDTO loanType, long id);
	
	public void deleteLoanTypeById(long loanTypeId);
	
	public LoanType getLoanTypeById (long loanTypeId);
	public List<LoanType> getAllLoanType();
}
