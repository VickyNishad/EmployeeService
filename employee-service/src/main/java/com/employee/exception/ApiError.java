/**
 * 
 */
package com.employee.exception;

/**
 * 
 */
public class ApiError {

	/**
	 * 
	 */
	public ApiError() {
		// TODO Auto-generated constructor stub
	}

	private String errorCode;
	private String message;
	private String status;

	/**
	 * @return the errorCode
	 */

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the object
	 */
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

	public ApiError(String errorCode, String message, String status) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ApiError [errorCode=" + errorCode + ", message=" + message + ", status=" + status + "]";
	}

}
