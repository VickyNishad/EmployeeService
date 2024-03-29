package com.employee.service;

import com.employee.entity.EmployeeDetailsRequest;
import com.employee.entity.EmployeeResponse;

public interface EmployeeInterface {

	public EmployeeResponse getEmployeeById(String emp_id);
	public EmployeeResponse submitEmployeeDetails(EmployeeDetailsRequest employeeDetailsRequest);

	public EmployeeResponse updateEmployeeDetails(EmployeeDetailsRequest employeeDetailsRequest);

	public EmployeeResponse searchEmployees(String minAge,String maxAge,String emp_birth_year,String emp_name);
	
}
