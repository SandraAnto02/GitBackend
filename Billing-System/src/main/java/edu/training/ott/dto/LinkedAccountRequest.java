package edu.training.ott.dto;

import java.util.List;

import edu.training.ott.model.LinkedAccount;
import lombok.Getter;


@Getter
public class LinkedAccountRequest 
{
	
	private Integer userid;
	private List<LinkedAccount> linkedAccount;

}
