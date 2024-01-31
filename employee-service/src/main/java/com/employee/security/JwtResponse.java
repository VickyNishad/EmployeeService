package com.employee.security;

public class JwtResponse {
	
	private String status;
	private String message;
	private String accessToken;
	private String username;
	
	
	public JwtResponse() {
		super();
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
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}
	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	public JwtResponse(String status, String message, String accessToken, String username) {
		super();
		this.status = status;
		this.message = message;
		this.accessToken = accessToken;
		this.username = username;
	}

}
