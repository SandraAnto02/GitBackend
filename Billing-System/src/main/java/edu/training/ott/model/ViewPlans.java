package edu.training.ott.model;

import org.springframework.stereotype.Component;

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
@Component
public class ViewPlans 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer planid;
	private String data;
	private String price;
	private String validity;
	private String voiceCall;
	private String sms;
	private String offers;
	private String imgsrc;

}
