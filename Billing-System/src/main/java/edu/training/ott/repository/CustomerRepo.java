package edu.training.ott.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.training.ott.model.Customer;
import java.util.List;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>
{
	Optional<Customer> findByphone(String phone);
	
	Optional<Customer> findByUserid(long userid);
	
	  

}
