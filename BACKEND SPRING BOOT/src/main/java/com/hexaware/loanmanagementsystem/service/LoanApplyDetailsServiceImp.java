package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.loanmanagementsystem.dto.LoanApplyDetailsDTO;
import com.hexaware.loanmanagementsystem.entity.LoanApplyDetails;
import com.hexaware.loanmanagementsystem.exception.LoanApplyDetailsNotFoundException;
import com.hexaware.loanmanagementsystem.repository.LoanApplyDetailsRepository;

@Service
public class LoanApplyDetailsServiceImp implements ILoanApplyDetailsService {

	@Autowired
	private LoanApplyDetailsRepository loanApplyDetailsRepository;

	Logger logger = LoggerFactory.getLogger(LoanApplyDetailsServiceImp.class);

	@Override
	public LoanApplyDetails createLoanApplyDetails(LoanApplyDetailsDTO loanApplyDetailDto) {

		LoanApplyDetails loanApplyDetail = new LoanApplyDetails();
	

		
		
		
		loanApplyDetail.setLoanTypeName(loanApplyDetailDto.getLoanTypeName());
		loanApplyDetail.setLoanAmount(loanApplyDetailDto.getLoanAmount());
		loanApplyDetail.setLoanStatus(loanApplyDetailDto.getLoanStatus());
		loanApplyDetail.setLoanOrginationDate(loanApplyDetailDto.getLoanOrginationDate());
		loanApplyDetail.setPropertyAddress(loanApplyDetailDto.getPropertyAddress());
		loanApplyDetail.setCustomerName(loanApplyDetailDto.getCustomerName());

		return loanApplyDetailsRepository.save(loanApplyDetail);
	}

	@Override
	public LoanApplyDetails updateApplyDetails(LoanApplyDetailsDTO loanApplyDetailDto, long loanNo) {
	    LoanApplyDetails loanApplyDetail = loanApplyDetailsRepository.findById(loanNo)
	            .orElseThrow(() -> new LoanApplyDetailsNotFoundException(HttpStatus.FOUND, "Loan not yet applied"));

	    // Update relevant fields
	    loanApplyDetail.setLoanTypeName(loanApplyDetailDto.getLoanTypeName());
	    loanApplyDetail.setLoanAmount(loanApplyDetailDto.getLoanAmount());
	    loanApplyDetail.setLoanStatus(loanApplyDetailDto.getLoanStatus());
	    loanApplyDetail.setLoanOrginationDate(loanApplyDetailDto.getLoanOrginationDate());
	    loanApplyDetail.setPropertyAddress(loanApplyDetailDto.getPropertyAddress());
	    loanApplyDetail.setCustomerName(loanApplyDetailDto.getCustomerName());

	    return loanApplyDetailsRepository.save(loanApplyDetail);
	}


	@Override
	public void deleteApplyDetails(long loanApplyDetailId) {
	    loanApplyDetailsRepository.deleteById(loanApplyDetailId);
	}

	@Override
	public LoanApplyDetails getloanDetailsByLoanNumber(long loanNumber) {

		return loanApplyDetailsRepository.findById(loanNumber)
				.orElseThrow(() -> new LoanApplyDetailsNotFoundException(HttpStatus.FOUND, "Loan not yet applied"));
	}

	@Override
	public List<LoanApplyDetails> getAllLoanDetails() {

		List<LoanApplyDetails> loanApplyDetails = loanApplyDetailsRepository.findAll();

		if (loanApplyDetails.isEmpty()) {
			throw new LoanApplyDetailsNotFoundException(HttpStatus.FOUND, "Loan not yet applied");
		}

		return loanApplyDetails;
	}

	@Override
	public List<LoanApplyDetails> getloanDetailsByCustomerName(String customerName) {

		List<LoanApplyDetails> loanApplyDetails = loanApplyDetailsRepository.findByCustomerName(customerName);

		if (loanApplyDetails.isEmpty()) {
			throw new LoanApplyDetailsNotFoundException(HttpStatus.FOUND, "Loan not yet applied");
		}

		return loanApplyDetails;
	}

}
