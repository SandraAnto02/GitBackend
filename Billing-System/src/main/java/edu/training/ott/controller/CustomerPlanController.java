package edu.training.ott.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.ott.model.CustomerPlan;
import edu.training.ott.service.CustomerPlanService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins ="http://localhost:4200")
public class CustomerPlanController 
{
	@Autowired
	CustomerPlanService customerPlanService;
	
	@PostMapping("/customerbuy")
	public CustomerPlan buyPlan(@RequestBody CustomerPlan customerPlan)
	{
		return  customerPlanService.buyPlan(customerPlan);	
	}
	
	@GetMapping("/byuser/{userid}")
	public List<CustomerPlan> getplanByCusId(@PathVariable Integer userid)
	{
		return customerPlanService.getplanByCusId(userid);
	}

}
