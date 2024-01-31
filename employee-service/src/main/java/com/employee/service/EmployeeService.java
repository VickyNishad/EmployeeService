package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.commonservice.CommonService;
import com.employee.entity.EmployeeDetails;
import com.employee.entity.EmployeeDetailsRequest;
import com.employee.entity.EmployeeResponse;
import com.employee.exception.CustomeException;
import com.employee.exception.EntityNotFoundException;
import com.employee.exception.RequestNotFoundException;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CommonService commonService;

	EmployeeDetails employeeDetails = null;
	EmployeeResponse response = null;

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public EmployeeResponse submitEmployeeDetails(EmployeeDetailsRequest employeeDetailsRequest) {
		// TODO Auto-generated method stub

		try {

			employeeDetails = new EmployeeDetails();

//			System.out.println(commonService.generateAndSaveSequentialNumber());


			if (commonService.isValidMobileNumber(employeeDetailsRequest.getEmp_contact())) {
				employeeDetails.setEmp_contact(employeeDetailsRequest.getEmp_contact());

			} else {
				throw new RequestNotFoundException("mobile number must be 10 digit or start with 6/7/8/9", "400",
						"Bad Request");
			}
			employeeDetails.setEmp_id(commonService.generateAndSaveSequentialNumber());
			employeeDetails.setEmp_name(employeeDetailsRequest.getEmp_name());
			
			employeeDetails.setEmp_age(employeeDetailsRequest.getEmp_age());
			employeeDetails.setEmp_birth_year(employeeDetailsRequest.getEmp_birth_year());
			employeeDetails.setEmp_marital_status(employeeDetailsRequest.getEmp_marital_status());
			employeeDetails.setEmp_gender(employeeDetailsRequest.getEmp_gender());
			employeeDetails.setEmp_department(employeeDetailsRequest.getEmp_department());
			employeeDetails.setEmp_designation(employeeDetailsRequest.getEmp_designation());
			employeeDetails.setEmp_address(employeeDetailsRequest.getEmp_address());

			employeeRepository.save(employeeDetails);

			response = new EmployeeResponse();
			response.setStatus("sucess");
			response.setErrorcode("0");
			response.setMessage("recod inserted successfully !");
			response.setResult(employeeDetails);
			return response;

		} catch (RequestNotFoundException e) {
			// TODO: handle exception
			throw new RequestNotFoundException(e.getMessage(), e.getHttpStatus(), e.getStatus());
		} catch (Exception e) {
			// TODO: handle exception
			throw new CustomeException(e.getLocalizedMessage());

		}
	}

	@Override
	public EmployeeResponse updateEmployeeDetails(EmployeeDetailsRequest employeeDetailsRequest) {
		// TODO Auto-generated method stub

		try {
			if (employeeDetailsRequest.getEmp_id().isBlank() || employeeDetailsRequest.getEmp_id().isEmpty()) {
				throw new EntityNotFoundException("emp_id can not blank");
			}

			Optional<EmployeeDetails> employee_Details = employeeRepository
					.findById(employeeDetailsRequest.getEmp_id());

			if (employee_Details.isEmpty()) {

				throw new EntityNotFoundException(
						"recod not found on this emp_id :" + employeeDetailsRequest.getEmp_id());

			} else {

				employeeDetails.setEmp_id(employeeDetailsRequest.getEmp_id());

				if (employeeDetailsRequest.getEmp_gender().equalsIgnoreCase("male")) {

					employeeDetails.setEmp_name(employeeDetailsRequest.getEmp_name());
					employeeDetails.setEmp_age(employeeDetailsRequest.getEmp_age());
					employeeDetails.setEmp_birth_year(employeeDetailsRequest.getEmp_birth_year());
					employeeDetails.setEmp_gender(employeeDetailsRequest.getEmp_gender());

					employeeDetails.setEmp_marital_status(employee_Details.get().getEmp_marital_status());
					employeeDetails.setEmp_department(employee_Details.get().getEmp_department());
					employeeDetails.setEmp_designation(employee_Details.get().getEmp_designation());
					employeeDetails.setEmp_address(employee_Details.get().getEmp_address());

					employeeRepository.save(employeeDetails);

					response = new EmployeeResponse();
					response.setStatus("sucess");
					response.setErrorcode("0");
					response.setMessage("recod updated successfully !");
					response.setResult(employeeDetails);
					return response;

				} else {
					employeeDetails.setEmp_name(employee_Details.get().getEmp_name());
					employeeDetails.setEmp_age(employeeDetailsRequest.getEmp_age());
					employeeDetails.setEmp_birth_year(employeeDetailsRequest.getEmp_birth_year());
					employeeDetails.setEmp_gender(employeeDetailsRequest.getEmp_gender());

					employeeDetails.setEmp_marital_status(employee_Details.get().getEmp_marital_status());
					employeeDetails.setEmp_department(employee_Details.get().getEmp_department());
					employeeDetails.setEmp_designation(employee_Details.get().getEmp_designation());
					employeeDetails.setEmp_address(employee_Details.get().getEmp_address());

					employeeRepository.save(employeeDetails);

					response = new EmployeeResponse();
					response.setStatus("sucess");
					response.setErrorcode("0");
					response.setMessage("recod updated successfully !");
					response.setResult(employeeDetails);
					return response;
				}
			}

		} catch (EntityNotFoundException e) {
			// TODO: handle exception
			throw new EntityNotFoundException(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			throw new CustomeException("internal server error", "500", "INTERNAL SERVER ERROR");
		}

	}

	@Override
	public EmployeeResponse getEmployeeById(String emp_id) {
		// TODO Auto-generated method stub
		try {

			if (emp_id.isBlank() || emp_id.isEmpty()) {
				throw new EntityNotFoundException("emp_id can not blank");
			}

			Optional<EmployeeDetails> employee_Details = employeeRepository.findById(emp_id);
			if (employee_Details.isEmpty()) {
				throw new EntityNotFoundException("recod not found on this emp_id :" + emp_id, "404", "Not Found");
			}

			response = new EmployeeResponse();
			response.setStatus("sucess");
			response.setErrorcode("0");
			response.setMessage("recod retrive successfully !");
			response.setResult(employee_Details.get());
			return response;

		} catch (EntityNotFoundException e) {
			// TODO: handle exception
			throw new EntityNotFoundException(e.getMessage(), e.getHttpStatus(), e.getStatus());
		} catch (Exception e) {
			// TODO: handle exception
			throw new CustomeException("internal server error", "500", "INTERNAL SERVER ERROR");

		}
	}

	@Override
	public EmployeeResponse searchEmployees(String minAge, String maxAge, String empBirthYear, String empName) {
		// TODO Auto-generated method stub
		try {
			List<EmployeeDetails> employee_Details = null;

			if (minAge != null && maxAge != null) {
				employee_Details = employeeRepository.findByEmpAgeBetween(minAge, maxAge);
			} else if (empBirthYear != null) {
				employee_Details = employeeRepository.findByEmpBirthYear(empBirthYear);
			} else if (empName != null) {
				employee_Details = employeeRepository.findByEmpNameContainingIgnoreCase(empName);
			} else {
				// Handle the case where no valid search criteria are provided
				// For now, returning an empty list as an example
				employee_Details = employeeRepository.findAll();
			}

			if (employee_Details.isEmpty()) {
				throw new EntityNotFoundException("recod not found", "404", "Not Found");
			}

			response = new EmployeeResponse();
			response.setStatus("sucess");
			response.setErrorcode("0");
			response.setMessage("recod retrive successfully !");
			response.setResult(employee_Details);
			return response;

		} catch (EntityNotFoundException e) {
			// TODO: handle exception
			throw new EntityNotFoundException(e.getMessage(), e.getHttpStatus(), e.getStatus());
		} catch (Exception e) {
			// TODO: handle exception
			throw new CustomeException("internal server error", "500", "INTERNAL SERVER ERROR");
		}
	}

}
