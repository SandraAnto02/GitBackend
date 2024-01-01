package edu.training.ott.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	private String username;
	private String phone;
	private String email;
	private String password;
	
	private boolean isPaymentMade;
	private boolean isServicesActive;
	
	@OneToMany
    private List<LinkedAccount> linkedAccounts;

//	(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	public void resumeServices() 
	{
        if (isPaymentMade) 
        {
            isServicesActive = true;
            
        }
    }
 
    public void terminateServices() 
    {
        isServicesActive = false;
    }
}
