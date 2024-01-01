package edu.training.ott.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.training.ott.model.ViewPlans;
import edu.training.ott.repository.ViewPlansRepo;

@Service
public class ViewPlansService 
{
	@Autowired
	ViewPlansRepo repo;
	
	
	public List<ViewPlans> viewCustomer()
	{
		return repo.findAll();
	}

}
