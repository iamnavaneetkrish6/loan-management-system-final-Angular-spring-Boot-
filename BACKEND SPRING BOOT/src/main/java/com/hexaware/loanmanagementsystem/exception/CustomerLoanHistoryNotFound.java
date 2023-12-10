package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CustomerLoanHistoryNotFound extends ResponseStatusException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5703181565459043132L;

	public CustomerLoanHistoryNotFound(HttpStatusCode status, String reason) {
		super(status, reason);
	}

}
