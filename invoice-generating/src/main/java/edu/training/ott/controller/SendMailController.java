package edu.training.ott.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.ott.model.CheckCustomer;
import edu.training.ott.model.SendMail;
import edu.training.ott.service.SendMailService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SendMailController 
{
	private final SendMailService userservice;
	@CrossOrigin(origins="http://localhost:4200")

	@PostMapping
	public CheckCustomer addUser(@RequestBody SendMail mailData ) 
	{

		System.out.println(mailData);

		String msg=userservice.sendMail(mailData);

		return  new CheckCustomer(msg);

	}

}
