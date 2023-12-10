package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CustomerDetailsNotFoundException extends ResponseStatusException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerDetailsNotFoundException(HttpStatusCode status, String message) {
		super(status, message);
		
	}

}
