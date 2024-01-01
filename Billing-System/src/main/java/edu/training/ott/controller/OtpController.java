package edu.training.ott.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.ott.model.CheckCustomer;
import edu.training.ott.service.SmsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j      
public class OtpController 
{

	@Autowired
	private SmsService otpService;
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/requestotp")
	public ResponseEntity<Map<String, String>> requestOTP(@RequestBody String requestBody) 
	{

	    String phoneNumber = requestBody;
	    System.out.println(phoneNumber);

	    String otp = otpService.generateRandomOTP(requestBody);


	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

	}

	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/validateotp")
	public CheckCustomer validateOtp(@RequestBody String otpno)
	{
		String otpvalue=otpService.otpset;
		System.out.println("this is printint from the boot "+otpno);
		String msg=otpService.validateOtp(otpno);
		return new CheckCustomer(msg);
	}

	
}