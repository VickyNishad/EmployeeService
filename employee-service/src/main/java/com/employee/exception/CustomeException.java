/**
 * 
 */
package com.employee.exception;

import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class CustomeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CustomeException() {
		// TODO Auto-generated constructor stub
	}

	private String message;
	private String httpStatus;
	private String status;

	
	
	public String getMessage() {
		return message;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getHttpStatus() {
		return httpStatus;
	}
	
	
	public CustomeException(String message) {
		this.message = message;
	}

	public CustomeException(String message, String httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public CustomeException(String message, String httpStatus, String status) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.status = status;
	}

}
