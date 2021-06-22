package com.Spring.bbregist.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.bbregist.Userservice.DonorDetails;
import com.Spring.bbregist.model.Donor;
import com.Spring.bbregist.model.Hospital;
import com.Spring.bbregist.web.dto.Donordto;

@RestController
public class Inviteexe {

	@Autowired
	DonorDetails s;
	
	@GetMapping("/hospital-home/{email}")
	public ModelAndView getCustomerByFirstName(@PathVariable(name="email") String email,ModelAndView mvw) throws AddressException, MessagingException, IOException {
		Donor r = s.findByEmail(email);
		
		LocalDate today = LocalDate.now();
		
		int month = today.getMonthValue();
		
		LocalDate lastinvite=r.getInvitedate();
	    
	
		if(r.getInvite()==null)
		{
	         s.UpdateInvite(email);
		s.UpdateInvitetime(email);
		EmailController t  = new EmailController();
		System.out.println(r.getEmail()+" hi  ");
		t.sendmail(r.getEmail(),r.getFirstname());
		Long i=(long) 1;
		r.setInvite( i);
		System.out.println(r.getInvite()+" ");
		mvw.setViewName("invitesent");
		}
		else if(r.getInvite()!=null){

			Period period=Period.between(today, lastinvite);
	         if(period.getDays()>=30)
	         {
				s.UpdateInviteany(email);
				s.UpdateInvitetime(email);
				EmailController t  = new EmailController();
				System.out.println(r.getEmail()+" hi  ");
				t.sendmail(r.getEmail(),r.getFirstname());
				Long i=(long) 1;
				r.setInvite( i);
				System.out.println(r.getInvite()+" ");
	         mvw.setViewName("invitesent");
	         
	         }
	         else
	        	 mvw.setViewName("resting");
				
		}
			
		else {
			 mvw.setViewName("error");
				
			
		}
	
		
		return mvw;
		/*for (int i = 0; i < r.size(); i++) {
			
			try {
				System.out.println(r.get(i).getEmail());
				t.sendmail(r.get(i).getEmail());
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	
		
	
		
	}}
