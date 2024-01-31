package com.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeDetails {
	
	@Id
	private String emp_id;
	private String emp_name;
	private String emp_contact;
	private String emp_age;
	private String emp_gender;
	private String emp_birth_year;
	private String emp_marital_status;
	private String emp_department;
	private String emp_designation;
	private String emp_address;

	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * @return the emp_contact
	 */
	public String getEmp_contact() {
		return emp_contact;
	}



	/**
	 * @param emp_contact the emp_contact to set
	 */
	public void setEmp_contact(String emp_contact) {
		this.emp_contact = emp_contact;
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
	 * @return the emp_name
	 */
	public String getEmp_name() {
		return emp_name;
	}

	/**
	 * @param emp_name the emp_name to set
	 */
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	/**
	 * @return the emp_age
	 */
	public String getEmp_age() {
		return emp_age;
	}

	/**
	 * @param emp_age the emp_age to set
	 */
	public void setEmp_age(String emp_age) {
		this.emp_age = emp_age;
	}

	/**
	 * @return the emp_gender
	 */
	public String getEmp_gender() {
		return emp_gender;
	}

	/**
	 * @param emp_gender the emp_gender to set
	 */
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	/**
	 * @return the emp_birth_year
	 */
	public String getEmp_birth_year() {
		return emp_birth_year;
	}

	/**
	 * @param emp_birth_year the emp_birth_year to set
	 */
	public void setEmp_birth_year(String emp_birth_year) {
		this.emp_birth_year = emp_birth_year;
	}

	/**
	 * @return the emp_marital_status
	 */
	public String getEmp_marital_status() {
		return emp_marital_status;
	}

	/**
	 * @param emp_marital_status the emp_marital_status to set
	 */
	public void setEmp_marital_status(String emp_marital_status) {
		this.emp_marital_status = emp_marital_status;
	}

	/**
	 * @return the emp_department
	 */
	public String getEmp_department() {
		return emp_department;
	}

	/**
	 * @param emp_department the emp_department to set
	 */
	public void setEmp_department(String emp_department) {
		this.emp_department = emp_department;
	}

	/**
	 * @return the emp_designation
	 */
	public String getEmp_designation() {
		return emp_designation;
	}

	/**
	 * @param emp_designation the emp_designation to set
	 */
	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}

	/**
	 * @return the emp_address
	 */
	public String getEmp_address() {
		return emp_address;
	}

	/**
	 * @param emp_address the emp_address to set
	 */
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public EmployeeDetails(String emp_id, String emp_name, String emp_age, String emp_gender, String emp_birth_year,
			String emp_marital_status, String emp_department, String emp_designation, String emp_address) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_age = emp_age;
		this.emp_gender = emp_gender;
		this.emp_birth_year = emp_birth_year;
		this.emp_marital_status = emp_marital_status;
		this.emp_department = emp_department;
		this.emp_designation = emp_designation;
		this.emp_address = emp_address;
	}
	
}
