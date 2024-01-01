package edu.training.ott.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.ott.model.ViewPlans;
import edu.training.ott.service.ViewPlansService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class ViewPlansController
{
	@Autowired
	ViewPlansService viewPlanService;
	
    @GetMapping("/viewplans")
	public List<ViewPlans> viewPlans()
	{
		return viewPlanService.viewCustomer();
	}
    
    

}
