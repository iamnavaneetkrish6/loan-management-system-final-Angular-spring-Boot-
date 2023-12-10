package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({Exception.class, AdminNotFoundException.class,CustomerAccountDetailsNotFoundException.class,CustomerDetailsNotFoundException.class,CustomerLoanInformationNotFoundException.class,LoanApplyDetailsNotFoundException.class, PropertyDetailsNotFound.class,LoanTypeNotFoundException.class,CustomerLoanHistoryNotFound.class})
	public ResponseEntity<String> handleResourceExceptions(Exception e) {
		
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
	}

}
