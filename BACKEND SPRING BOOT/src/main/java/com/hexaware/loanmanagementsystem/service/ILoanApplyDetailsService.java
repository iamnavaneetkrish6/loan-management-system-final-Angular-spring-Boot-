package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import com.hexaware.loanmanagementsystem.dto.LoanApplyDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.LoanApplyDetails;


public interface ILoanApplyDetailsService {

	public LoanApplyDetails createLoanApplyDetails(LoanApplyDetailsDTO loanApplyDetailDto);
	public LoanApplyDetails updateApplyDetails (LoanApplyDetailsDTO loanApplyDetailDto,long loanNo);
	
	public void deleteApplyDetails(long loanApplyDetailId);
	
	public LoanApplyDetails getloanDetailsByLoanNumber(long loanNumber);
	public List<LoanApplyDetails> getAllLoanDetails();
	
	
	
	public List<LoanApplyDetails> getloanDetailsByCustomerName(String customerName);
	
}
