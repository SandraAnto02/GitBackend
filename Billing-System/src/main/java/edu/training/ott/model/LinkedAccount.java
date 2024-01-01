package edu.training.ott.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LinkedAccount 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer linkedid;
	private String linkedname;
	private String linkedphone;
	private String linkedemail;
	

}
