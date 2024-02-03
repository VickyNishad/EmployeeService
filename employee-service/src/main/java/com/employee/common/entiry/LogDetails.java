package com.employee.common.entiry;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class LogDetails {

	public LogDetails() {
		// TODO Auto-generated constructor stub
	}
	@Id
	private long log_id;
	private String emp_id;
	private LocalDateTime timestamp;
	private String log;
	/**
	 * @return the log_id
	 */
	public long getLog_id() {
		return log_id;
	}
	/**
	 * @param log_id the log_id to set
	 */
	public void setLog_id(long log_id) {
		this.log_id = log_id;
	}
	/**
	 * @return the emp_id
	 */
	public String getEmp_id() {
		return emp_id;
	}
	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the log
	 */
	public String getLog() {
		return log;
	}
	/**
	 * @param log the log to set
	 */
	public void setLog(String log) {
		this.log = log;
	}
	public LogDetails(long log_id, String emp_id, LocalDateTime timestamp, String log) {
		super();
		this.log_id = log_id;
		this.emp_id = emp_id;
		this.timestamp = timestamp;
		this.log = log;
	}
}
