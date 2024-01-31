package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, String> {

	@Query("SELECT e FROM EmployeeDetails e WHERE e.emp_age BETWEEN :minAge AND :maxAge")
	List<EmployeeDetails> findByEmpAgeBetween(@Param("minAge") String minAge, @Param("maxAge") String maxAge);

	@Query("SELECT e FROM EmployeeDetails e WHERE e.emp_birth_year = :empBirthYear")
	List<EmployeeDetails> findByEmpBirthYear(@Param("empBirthYear") String empBirthYear);

	@Query("SELECT e FROM EmployeeDetails e WHERE LOWER(e.emp_name) LIKE LOWER(concat('%', :empName, '%'))")
	List<EmployeeDetails> findByEmpNameContainingIgnoreCase(@Param("empName") String empName);
}