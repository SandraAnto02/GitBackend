package edu.training.ott.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.training.ott.dto.LinkedAccountRequest;
import edu.training.ott.model.Customer;
import edu.training.ott.repository.CustomerRepo;
import edu.training.ott.repository.LinkedAccountRepo;

@Service
public class CustomerService 
{
	@Autowired
	Customer customer;
	
	@Autowired
	CustomerRepo repo;
	
	
	
	@Autowired
	LinkedAccountRepo linkRepo;
	
	public Customer registerCustomer(Customer customer)
	{
		return repo.save(customer);
	}
	
	
	
	public boolean existsInDatabase(String number) 
	{

		 Optional<Customer> phoneNumber = repo.findByphone(number);

		 return phoneNumber.isPresent();

	}
	
	
	public List<Customer> viewCustomer()
	{
		return repo.findAll();
	}
	
	
	public Optional<Customer> userByPhone(String phone)
	{
		return repo.findByphone(phone);
	}
	
	
	
	public Customer LinkAccountwithCustomer(LinkedAccountRequest linkAccReq)
	{
		Customer primaryAccount = repo.findById(linkAccReq.getUserid())
   	    .orElseThrow(() -> new RuntimeException("Account not found"));
		
		// Check if the user already has 4 family members
		if (primaryAccount.getLinkedAccounts().size() + linkAccReq.getLinkedAccount().size() > 4) 
		{
			 throw new RuntimeException("Cannot add more than 4 family members to this account.");
		}
		
		// Save and add the new family members
		linkAccReq.getLinkedAccount().forEach(account -> {
		linkRepo.save(account);
		});

		primaryAccount.getLinkedAccounts().addAll(linkAccReq.getLinkedAccount());
		return repo.save(primaryAccount);
	}
	
	public Customer viewLinkAccounts(Integer linkedid)
	{
		Optional<Customer> customer =repo.findById(linkedid);
		return customer.orElse(null);
		
	}
	
	
//	public String makePayment(Long userId, Long invoiceId) {
//		Optional<Customer> userOptional = repo.findByUserid(userId);
//	    Optional<CustomerPlan> invoiceOptional = planRepo.findByUserid(invoiceId);
// 
//	    if (userOptional.isPresent() && invoiceOptional.isPresent()) {
//	    	Customer user = userOptional.get();
//	    	CustomerPlan invoice = invoiceOptional.get();
// 
//	        if (user.isPaymentMade()) {
//	            return "Payment already made";
//	        }
// 
//	        if (invoice.isPaid()) {
//	            user.setPaymentMade(true);
//	            user.setServicesActive(true);
//	            repo.save(user);
//	            return "Payment successful, services activated";
//	        } else {
//	            return "Payment failed";
//	        }
//	    } else {
//	        return "User or invoice not found";  // Handle the case where the entities are not found.
//	    }
//    }

	
	public String terminateServices(Long userId)
	{
	    Optional<Customer> userOptional = repo.findByUserid(userId);
 
	    if (userOptional.isPresent()) 
	    {
	    	Customer user = userOptional.get();
	        user.terminateServices();
	        repo.save(user);
	        return "Services terminated";
	    } 
	    else 
	    {
	        return "User not found";  // Handle the case where the user is not found.
	    }
	}
	
	public String resumeServices(Long userId)
	{
	    Optional<Customer> userOptional = repo.findByUserid(userId);
 
	    if (userOptional.isPresent())
	    {
	    	Customer user = userOptional.get();
	        user.resumeServices();
	        repo.save(user);
	        return "Services resumed";
	    } 
	    else 
	    {
	        return "User not found";  // Handle the case where the user is not found.
	    }
	}

	
	

}
