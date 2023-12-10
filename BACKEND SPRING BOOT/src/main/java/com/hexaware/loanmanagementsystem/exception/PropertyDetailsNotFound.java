package com.hexaware.loanmanagementsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class PropertyDetailsNotFound extends ResponseStatusException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 556488032203272924L;

	public PropertyDetailsNotFound(HttpStatusCode status, String reason) {
		super(status, reason);
	}

}
