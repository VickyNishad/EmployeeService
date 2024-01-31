package com.employee.commonservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CommonService {

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


}
