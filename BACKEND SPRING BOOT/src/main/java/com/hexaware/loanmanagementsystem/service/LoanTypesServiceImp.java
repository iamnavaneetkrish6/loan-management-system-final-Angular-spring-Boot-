package com.hexaware.loanmanagementsystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.loanmanagementsystem.dto.LoanTypeDTO;
import com.hexaware.loanmanagementsystem.entity.LoanType;
import com.hexaware.loanmanagementsystem.exception.LoanTypeNotFoundException;
import com.hexaware.loanmanagementsystem.repository.LoanTypesRepository;

@Service
public class LoanTypesServiceImp implements ILoanTypesService {

	@Autowired
	private LoanTypesRepository loanTypeRepository;

	Logger logger = LoggerFactory.getLogger(LoanTypesServiceImp.class);

	@Override
	public LoanType createLoanType(LoanTypeDTO loanType) {

		LoanType loanTypes = new LoanType();
		loanTypes.setLoanTypeName(loanType.getLoanTypeName());
		loanTypes.setLoanInterestRate(loanType.getLoanInterestRate());
		loanTypes.setLoanTerm(loanType.getLoanTerm());
		loanTypes.setLoanDescription(loanType.getLoanDescription());
		loanTypes.setLoanManagementFees(loanType.getLoanManagementFees());

		logger.info("LoanType Implementation -added LoanType data into database successfully ");

		return loanTypeRepository.save(loanTypes);
	}

	@Override
	public LoanType updateLoanType(LoanTypeDTO loanType, long id) {

		LoanType loanTypes = loanTypeRepository.findById(id).orElseThrow(() -> new LoanTypeNotFoundException(HttpStatus.NOT_FOUND, "Loantype not found"));
		loanTypes.setLoanTypeId(loanTypes.getLoanTypeId());
		loanTypes.setLoanTypeName(loanType.getLoanTypeName());
		loanTypes.setLoanInterestRate(loanType.getLoanInterestRate());
		loanTypes.setLoanTerm(loanType.getLoanTerm());
		loanTypes.setLoanDescription(loanType.getLoanDescription());
		loanTypes.setLoanManagementFees(loanType.getLoanManagementFees());

		logger.info(
				"LoanType Service Implementation -Updated the Admin data in existing record in  database successfully ");

		return loanTypeRepository.save(loanTypes);
	}

	@Override
	public void deleteLoanTypeById(long loanTypeId) {
	    loanTypeRepository.deleteById(loanTypeId);
	    logger.info("LoanType Data with ID: {} deleted successfully in the LoanType Service Implementation", loanTypeId);
	}

	@Override
	public LoanType getLoanTypeById(long loanTypeId) {

		logger.info("LoanType Service Implementation-Fetching LoanType with ID :{}", loanTypeId);

		return loanTypeRepository.findById(loanTypeId)
				.orElseThrow(() -> new LoanTypeNotFoundException(HttpStatus.NOT_FOUND, "Loantype not found"));
	}

	@Override
	public List<LoanType> getAllLoanType() {

		logger.info("LoanType Service Implementation- Fetching all LoanType ");

		List<LoanType> loanTypes = loanTypeRepository.findAll();

		if (loanTypes.isEmpty()) {
			throw new LoanTypeNotFoundException(HttpStatus.NOT_FOUND, "Loantype not found");
		}

		return loanTypes;
	}

}
