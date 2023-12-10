package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class LoanTypeNotFoundException extends ResponseStatusException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6719806927854342079L;

	public LoanTypeNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);
	}

}
