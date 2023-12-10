package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CustomerLoanInformationNotFoundException extends ResponseStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerLoanInformationNotFoundException(HttpStatusCode status, String message) {
		super(status, message);
	}

}
