package edu.training.ott.service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import edu.training.ott.model.SendMail;

@Service
public class SendMailService 
{
	
	
	public String sendMail(SendMail mailData)
	{
		String smtpHostServer = "smtp.office365.com";
        final String emailID = "lokeshpulluru1972@outlook.com"; //Outlook email address
        final String password = "Loki@2002";                    // outlook account password
        String toEmail = mailData.getEmail();
        
        String subject = "Successful Registration and Account Number";
        
     // type mail body
        String messageBody = "dear"+mailData.getUsername()+", you have recharged your phone no. "+ mailData.getPhone()+" with Rs."+mailData.getPrice()+ " "+mailData.getPlanname()+"today with activation date"+ mailData.getActivation_date()+ "and expiry date on "+mailData.getExpiry_date()+".\r\n"

                		+ " \r\n"

                		+ "thank you for choosing us and enjoy your day with your loved ones!"; 

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHostServer);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(props, new Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(emailID, password);
            }
        });
        
        sendEmail(session, emailID, subject, messageBody,toEmail);
        return "emailSent";    
	}
	
	public static void sendEmail(Session session, String fromEmail, String subject, String body,String toEmail)
	{
		try
        {
            MimeMessage msg = new MimeMessage(session);
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress(fromEmail, "Digi Hub"));
            msg.setReplyTo(InternetAddress.parse(toEmail, false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            System.out.println("Message is ready");

            Transport.send(msg);

            System.out.println("Email Sent Successfully!!");

        }
        catch (Exception e) 
		{
            e.printStackTrace();
        }
	}

}
