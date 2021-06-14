package com.Spring.bbregist.web;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.bbregist.Userservice.DonorDetails;
import com.Spring.bbregist.model.Donor;
import com.Spring.bbregist.model.Hospital;
import com.Spring.bbregist.web.dto.Donordto;

@RestController
public class Emailexe {

	@Autowired
	DonorDetails s;
	
	@GetMapping("/hospital-home/{email}/{phno}")
	public String getCustomerByFirstName(@PathVariable(name="email") String email,@PathVariable(name="phno") String phno) throws AddressException, MessagingException, IOException {
		Donor r = s.findByEmail(email);
	
		
		EmailController t  = new EmailController();
		System.out.println(r.getEmail());
		t.sendmail(r.getEmail(),r.getFirstname());
		Long i=(long) 1;
		r.setInvite( i);
		System.out.println(r.getInvite()+" "+ phno);
		
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
		
		return "<h1>Successfullysent</h1>";
		}  
		
}
