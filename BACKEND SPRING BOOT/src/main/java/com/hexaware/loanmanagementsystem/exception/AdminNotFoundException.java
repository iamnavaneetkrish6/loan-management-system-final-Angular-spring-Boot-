package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class AdminNotFoundException extends ResponseStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminNotFoundException(HttpStatusCode status, String message) {
		super(status, message);

	}

}
