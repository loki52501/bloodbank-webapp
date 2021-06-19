package com.Spring.bbregist.web;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.bbregist.Userservice.DonorDetails;


@RestController
public class EmailController {
    
	public EmailController() {
		super();
		
	}


	@Autowired
	DonorDetails repObj;
	
	@RequestMapping(value = "/sendemail")
	public String sendemail() throws AddressException, MessagingException, IOException {
		
	    return "Email sent successfully";   
	}
	
   
   public void sendmail(String email,String name) throws AddressException, MessagingException, IOException {
	   Properties props = new Properties();
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.port", "587");
	   props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	   
	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication("splblooddonorfinder@gmail.com", "savelives");
	      }
	   });
	   Message msg = new MimeMessage(session);
	   msg.setFrom(new InternetAddress("splblooddonorfinder@gmail.com", false));

	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
	   msg.setSubject("Hi");
	   msg.setContent("we need your hand in saving the lives of people come and join us, Don't miss your chance", "text/html");
	   msg.setSentDate(new Date());

	   MimeBodyPart messageBodyPart = new MimeBodyPart();
	   messageBodyPart.setContent("<h1>we need your hand in saving the lives of people come and join us, Don't miss your chance</h1>"
	   		+ "we are glad to have you "
	   		+ "from,"
	   		+ "slp hospital"
	   		+ "contact if intrested."+name, "text/html");

	   Multipart multipart = new MimeMultipart();
	   multipart.addBodyPart(messageBodyPart);
	   /*MimeBodyPart attachPart = new MimeBodyPart();

	   attachPart.attachFile("/home/appa/Documents/java_project/Email/src/main/java/em2.jpg");
	   multipart.addBodyPart(attachPart);*/
	   msg.setContent(multipart);
	   Transport.send(msg);   
	}



}
