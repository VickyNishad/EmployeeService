package com.employee.exception;

public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2164894582905910731L;

	public EntityNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	private String message;
	private String httpStatus;
	private String status;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the httpStatus
	 */
	public String getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public EntityNotFoundException(String message, String httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	public EntityNotFoundException(String message) {
		super();
		this.message = message;

	}


	

	public EntityNotFoundException(String message, String httpStatus, String status) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.status = status;
	}

	@Override
	public String toString() {
		return "EntityNotFoundException [message=" + message + ", httpStatus=" + httpStatus + ", status=" + status
				+ "]";
	}

}
