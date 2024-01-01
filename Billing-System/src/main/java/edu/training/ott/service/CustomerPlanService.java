package edu.training.ott.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.training.ott.model.CustomerPlan;
import edu.training.ott.repository.CustomerPlanRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerPlanService 
{
	
	private final CustomerPlanRepo customerPlanRepo;
	
	public CustomerPlan buyPlan(CustomerPlan customerPlan)
	{
		LocalDate activeDate = LocalDate.now();
		
		CustomerPlan planExist = customerPlanRepo.findByuseridAndplanidAndDate(
				
				customerPlan.getUserid(),
				customerPlan.getPlanid(),
				Date.from(activeDate.atStartOfDay(ZoneId.systemDefault()).toInstant())			
				);
		
		if(planExist != null)
		{
			throw new RuntimeException("ALready activated a plan");
		}
		
		
		//setting expiry date to the active date(14)
		LocalDate expiryDate = activeDate.plusDays(14);
		
		//converting local date to the active date to store in db
		Date activationDatedb =Date.from(activeDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date  expiryDatedb=Date.from(expiryDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		
		//setting this converted dates to the db
		customerPlan.setActivationdate(activationDatedb);
		customerPlan.setExpirydate(expiryDatedb);
		
		return customerPlanRepo.save(customerPlan);	
	}
	
	public List<CustomerPlan> getplanByCusId(Integer userid)
	{
		return customerPlanRepo.findByuserid(userid);
	}

}
