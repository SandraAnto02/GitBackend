package edu.training.ott.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.training.ott.repository.CustomerRepo;
import edu.training.ott.repository.LinkedAccountRepo;

public class LinkedAccountService 
{
	@Autowired
	private LinkedAccountRepo linkRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	

}
