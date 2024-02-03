package com.employee.commonservice;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.common.entiry.LogDetails;
import com.employee.common.repository.CommonRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;

import jakarta.transaction.Transactional;

@Service
public class CommonService {
	
	@Autowired
	private CommonRepository commonRepository;

	private static final String PREFIX = "P";
	private AtomicLong currentNumber = new AtomicLong(1);

	public CommonService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public String generateAndSaveSequentialNumber() {
		long nextNumber = currentNumber.getAndIncrement();
		String sequentialNumber = PREFIX + String.format("%011d", nextNumber);
		return sequentialNumber;
	}
	
	public boolean isValidMobileNumber(String mobileNumber) {
	    // Implement your logic here
	    // Check if it has 10 digits and starts with 6, 7, 8, or 9
	    return mobileNumber != null && mobileNumber.matches("[6-9]\\d{9}");
	}
	
	public void log(JSONPObject ob,String emp_id) {
		try {
			LogDetails logDetails = new LogDetails();
			
			logDetails.setLog_id(Long.parseLong(UUID.randomUUID().toString()));
			logDetails.setEmp_id(emp_id);
			logDetails.setTimestamp((LocalDateTime.now()));
			logDetails.setLog(ob.toString());
			
			commonRepository.save(logDetails);
			System.out.println("save log....");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
