/**
 * 
 */
package com.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author 
 *
 */
@ControllerAdvice
public class GlobalCustomeException extends ResponseEntityExceptionHandler {

	/**
	 * 
	 */
	public GlobalCustomeException() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(RequestNotFoundException.class)
	protected ResponseEntity<?> requestNotfoundException(RequestNotFoundException ex) {
		// TODO Auto-generated method stub
		ApiError error = new ApiError();
		error.setErrorCode("400");
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.toString());
		
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<?> entitytNotfoundException(EntityNotFoundException customeException) {
		// TODO Auto-generated method stub
		ApiError error = new ApiError();
		error.setErrorCode(customeException.getHttpStatus());
		error.setMessage(customeException.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.toString());
		
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomeException.class)
	protected ResponseEntity<?> requestNotfoundException(CustomeException ex) {
		// TODO Auto-generated method stub
		ApiError error = new ApiError();
		error.setErrorCode("500");
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
