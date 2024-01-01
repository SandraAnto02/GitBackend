package edu.training.ott.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.training.ott.model.CustomerPlan;

@Repository
public interface CustomerPlanRepo extends JpaRepository<CustomerPlan, Integer> 
{
    List<CustomerPlan> findByuserid(Integer userid);
    
    @Query("from CustomerPlan where userid=?1 and planid=?2 and expirydate=?3")
    CustomerPlan findByuseridAndplanidAndDate(Integer userid, Integer planid, Date from);
}
