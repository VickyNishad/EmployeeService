package com.employee.entity;

public class EmployeeResponse {
	private String status;
	private String errorcode;
	private String message;
	private Object result;

	public EmployeeResponse() {
		// TODO Auto-generated constructor stub
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

	/**
	 * @return the errorcode
	 */
	public String getErrorcode() {
		return errorcode;
	}

	/**
	 * @param errorcode the errorcode to set
	 */
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

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
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	public EmployeeResponse(String status, String errorcode, String message, Object result) {
		super();
		this.status = status;
		this.errorcode = errorcode;
		this.message = message;
		this.result = result;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [status=" + status + ", errorcode=" + errorcode + ", message=" + message + ", result="
				+ result + "]";
	}
	
	

}
