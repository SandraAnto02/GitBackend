package edu.training.ott.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPlan 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cusplanid;
	private Integer userid;
	private Integer planid;
	private String price;
	private Date activationdate;
	private Date expirydate;
	
}
