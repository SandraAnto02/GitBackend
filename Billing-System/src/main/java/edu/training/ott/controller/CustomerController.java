package edu.training.ott.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.training.ott.dto.LinkedAccountRequest;
import edu.training.ott.model.CheckCustomer;
import edu.training.ott.model.Customer;
import edu.training.ott.repository.CustomerRepo;
import edu.training.ott.service.CustomerService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@ResponseBody
	@PostMapping("/add")
	public Customer registerCustomer(@RequestBody Customer customer)
	{
		
		
		return  customerService.registerCustomer(customer);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/checkcustomer")
	public ResponseEntity<CheckCustomer> checkPhoneNumber(@RequestBody Map<String,String> map) 
	{
		String number = map.get("number");
		System.out.println(number);
	 boolean exists = customerService.existsInDatabase(number);
	 System.out.println(exists);
	 if (exists) 
	 {
	 return new ResponseEntity<CheckCustomer>(new CheckCustomer("EXIST"),HttpStatus.OK);
	 } 
	 else 
	 {
	 return new ResponseEntity<CheckCustomer>(new CheckCustomer("DOES NOT EXIST"),HttpStatus.OK);
	 }
	}
	
	
	
	@RequestMapping("/viewusers")
	public List<Customer> viewProduct()
	{
		return customerService.viewCustomer();
	}
	
	
	@GetMapping("/{phone}")
	public Optional<Customer> userByPhone(@PathVariable String phone )
	{
		return customerService.userByPhone(phone);
	}
	
	
	@PostMapping("/linkaccounts")
	public Customer LinkAccountwithCustomer(@RequestBody LinkedAccountRequest linkedAccountReq)
	 {
	 return customerService.LinkAccountwithCustomer(linkedAccountReq);

	 } 
	
	@GetMapping("/viewlinkaccounts/{userid}")
	public ResponseEntity<Customer> viewLinkAccounts(@PathVariable Integer userid )
	 {
		Customer customer = customerService.viewLinkAccounts(userid);
		if(customer != null)
		{
			return ResponseEntity.ok(customer);
		}
		else 
		{
			return ResponseEntity.notFound().build();
		}
		
	 } 
	
	@PutMapping("/{userId}/resume")
    public String resumeServices(@PathVariable Long userId) {
        return customerService.resumeServices(userId);
    }

    @PutMapping("/{userId}/terminate")
    public String terminateServices(@PathVariable Long userId) {
        return customerService.terminateServices(userId);
    }
	
	

}
