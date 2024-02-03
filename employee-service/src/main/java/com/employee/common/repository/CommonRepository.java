package com.employee.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.common.entiry.LogDetails;

@Repository
public interface CommonRepository extends JpaRepository<LogDetails, Long> {

	

}
