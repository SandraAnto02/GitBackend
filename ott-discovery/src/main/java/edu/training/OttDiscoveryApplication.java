package edu.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OttDiscoveryApplication 
{
	public static void main(String[] arg)
	{
		SpringApplication.run(OttDiscoveryApplication.class, arg);
	}

}




