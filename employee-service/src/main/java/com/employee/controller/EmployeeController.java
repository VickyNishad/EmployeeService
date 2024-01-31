package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeDetailsRequest;
import com.employee.entity.EmployeeResponse;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("api/v1/employee")
//@Validated
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/{emp_id}")
	public EmployeeResponse getEmployeeById(@PathVariable("emp_id") String emp_id) {
		// TODO Auto-generated method stub
		return employeeService.getEmployeeById(emp_id);
	}

	@PostMapping("/submitDetails")
	public EmployeeResponse submitEmployeeDetails( @RequestBody EmployeeDetailsRequest employeeDetailsRequest) {
		// TODO Auto-generated method stub
		return employeeService.submitEmployeeDetails(employeeDetailsRequest);
	}

	@PostMapping("/updateDetails")
	public EmployeeResponse updateEmployeeDetails(  @RequestBody EmployeeDetailsRequest employeeDetailsRequest) {
		// TODO Auto-generated method stub
		return employeeService.updateEmployeeDetails(employeeDetailsRequest);
	}

	@GetMapping("/search")
	public EmployeeResponse searchEmployees(

			@RequestParam(required = false) String minAge, 
			@RequestParam(required = false) String maxAge,
			@RequestParam(required = false) String empBirthYear,
			@RequestParam(required = false) String empName

	) {
		// TODO Auto-generated method stub
		return employeeService.searchEmployees(minAge, maxAge, empBirthYear, empName);
	}

}
