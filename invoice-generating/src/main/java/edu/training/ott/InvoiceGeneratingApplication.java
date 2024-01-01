package edu.training.ott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InvoiceGeneratingApplication 
{
	public static void main(String[] args)
	{
		SpringApplication.run(InvoiceGeneratingApplication.class, args);
	}

}
