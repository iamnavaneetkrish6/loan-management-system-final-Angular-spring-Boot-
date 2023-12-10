package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class LoanApplyDetailsNotFoundException extends ResponseStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoanApplyDetailsNotFoundException(HttpStatusCode status, String reason) {
		super(status, reason);
		// TODO Auto-generated constructor stub
	}

}
