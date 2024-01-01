package edu.training.ott.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import edu.training.ott.config.TwilioConfig;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SmsService
{

	@Autowired
	private TwilioConfig twilioConfig;
	
	public static String otpset;
   
	Map<String, String> otpStorage = new HashMap<>();
    
    

    public String generateRandomOTP(String phno) 
    {
        Random random = new Random();
        Integer otpValue = 100000 + random.nextInt(900000); // Generates a number between 100000 and 999999
        String otp= otpValue.toString();
        System.out.println(otpValue);
        sendOtp(phno,otp );
        otpset=otp;
        return String.valueOf(otpValue);

        
    }

    public boolean sendOtp(String phoneNumber, String otp)
    {
	try 
	{
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
		 Message message = Message.creator(
			      new com.twilio.type.PhoneNumber("+91"+phoneNumber),
			      new com.twilio.type.PhoneNumber("+19384448167"),

			      "Your OTP is:"+otp)
			    .create();

		 otpStorage.put(phoneNumber, otp);
		 return true;
	}catch(Exception e)

	{

	e.printStackTrace();

		return false;
	}
	
  }
    public String validateOtp(String otpget) 
    {
    	String msg;
		if (otpset.equals(otpget))
		{
			msg="validated";
		}
		else
		{
			msg="wrongotp";
		}
    	
		return msg;
	}
}
