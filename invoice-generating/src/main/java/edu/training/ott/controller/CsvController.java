package edu.training.ott.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.training.ott.model.UserInvoiceResponse;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/csv")
public class CsvController 
{
	@GetMapping("/data")
	public List<UserInvoiceResponse> getCsvData() throws FileNotFoundException, IOException 
	{
		List<UserInvoiceResponse> list = new ArrayList<>();
		
		File file = new File("C:\\Users\\sandra.a\\Downloads\\invoice.csv");
		
		try(                FileReader reader = new FileReader(file);
                BufferedReader bf = new BufferedReader(reader);)
        {
            String data ="";
            String[] invoiceData;
            while((data = bf.readLine())!=null)
            {
                UserInvoiceResponse userData = UserInvoiceResponse.builder().build();
                invoiceData = data.split(",");
                int i=1;
                for(String tempData:invoiceData)
                {
                    switch(i)
                    {
                    case 1: userData.setUser_plan_id(tempData);break;
                    case 2: userData.setUser_id(tempData);break;
                    case 3: userData.setPlan_id(tempData);break;
                    case 4: userData.setUsername(tempData);break;
                    case 5: userData.setEmail(tempData);break;
                    case 6: userData.setPhone(tempData);break;
                    case 7: userData.setPlan_name(tempData);break;
                    case 8: userData.setActivation_date(tempData);break;
                    case 9: userData.setExpiry_date(tempData);break;
                    case 10:userData.setPrice(tempData);break;
                   
                    }
                    i++;
                }
                list.add(userData);
                
                
                System.out.println();
            }
            list.stream().forEach(temp->{System.out.println(temp);});
        }
        return list;
	}

}
