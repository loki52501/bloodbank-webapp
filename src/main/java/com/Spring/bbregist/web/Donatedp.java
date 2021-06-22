package com.Spring.bbregist.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.bbregist.Userservice.DonorDetails;
import com.Spring.bbregist.model.Donor;

@RestController
public class Donatedp {

	public Donatedp(DonorDetails d) {
		super();
		this.d = d;
	}
	DonorDetails d;
	@RequestMapping("/hospital-home/donated/{email}")
	public ModelAndView donated(@PathVariable(name="email") String email, ModelAndView mvw) throws AddressException, MessagingException, IOException {
		
		Donor r=d.findByEmail(email);
		LocalDate today = LocalDate.now();
		LocalDate lastdonated=r.getDonateddate();
		
		if(r.getInvite()<=0||r.getInvite()==null)
		{	
			mvw.setViewName("notinvited");
		}	
		else if(r.getDonated()==0||r.getDonated()==null)
		{
	         d.UpdateDonatedfirst(email);
		d.UpdateDonatetime(email);
		EmailController t  = new EmailController();
		System.out.println(r.getEmail()+" hi  ");
		t.sendmail(r.getEmail(),r.getFirstname());
		Long i=(long) 1;
		r.setInvite( i);
		System.out.println(r.getInvite()+" ");
		mvw.setViewName("donatesent");
		}
		else if(r.getDonated()!=0){

			Period period=Period.between(today, lastdonated);
			if(period.getDays()>=30)
			{
				d.UpdateDonated(email);
				d.UpdateDonatetime(email);
				EmailController t  = new EmailController();
				System.out.println(r.getEmail()+" hi  ");
				t.sendmail(r.getEmail(),r.getFirstname());
				Long i=(long) 1;
				r.setInvite( i);
				System.out.println(r.getInvite()+" ");
				
				mvw.setViewName("donatesent");
			}
			else
				mvw.setViewName("resting");
		}
		else {
			mvw.setViewName("error");
		
		
		
	}
	return mvw;
	}
}