package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CustomerAccountDetailsNotFoundException extends ResponseStatusException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAccountDetailsNotFoundException(HttpStatusCode status, String message) {
		super(status, message);

	}

}
