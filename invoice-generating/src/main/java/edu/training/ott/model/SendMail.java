package edu.training.ott.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendMail 
{
	private String email;
	private String username;
	private String activation_date;
	private String expiry_date;
	private String planname;
	private String price;
	private String phone;
	
}
