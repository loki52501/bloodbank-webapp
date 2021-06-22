package com.Spring.bbregist.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import com.Spring.bbregist.Userservice.DonorDetails;
import com.Spring.bbregist.Userservice.HospitalDetails;
import com.Spring.bbregist.model.Donor;
import com.Spring.bbregist.model.Hospital;


@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	DonorDetails user1;

	@Autowired
	HospitalDetails h1;
	
	@RequestMapping("/donorlogin")
	public String donorlogin() {

	return "user_login";
	 

	    }
	  
	
	
	@RequestMapping("/donor-home")
	public String donorhome(Model model,Authentication authentication) {
		
		 authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		// getUsername() - Returns the username used to authenticate the user.
		System.out.println("User name: " + userDetails.getUsername()+" "+user1.findByEmail(userDetails.getUsername()).getInvite());

		// getAuthorities() - Returns the authorities granted to the user.
		System.out.println("User has authorities: " + userDetails.getAuthorities());
		model.addAttribute("name",user1.findByEmail(userDetails.getUsername()).getFirstname());
model.addAttribute("email",user1.findByEmail(userDetails.getUsername()).getEmail());
model.addAttribute("city",user1.findByEmail(userDetails.getUsername()).getCity());
model.addAttribute("phno",user1.findByEmail(userDetails.getUsername()).getPhno());
model.addAttribute("bloodgroup",user1.findByEmail(userDetails.getUsername()).getBloodgroup());
model.addAttribute("invite", user1.findByEmail(userDetails.getUsername()).getInvite());
model.addAttribute("donatetime", user1.findByEmail(userDetails.getUsername()).getDonateddate());
model.addAttribute("donated",  user1.findByEmail(userDetails.getUsername()).getDonated());
model.addAttribute("daccept",user1.findByEmail(userDetails.getUsername()).getDaccepted() );
	return "login";
	}

	@PostMapping("/donor-home")
	public String donoraccept(HttpServletRequest req,Authentication authentication) {
		

		 authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email=userDetails.getUsername();
		String dac=req.getParameter("action");
		System.out.println(dac+" like ");
		if(dac.matches("ACCEPT"))
		{

			user1.UpdateDaccept(email);
			System.out.println("hik accept");
			return "redirect:/donor-home?accept"; 
			
		}
		else if(dac.matches("DECLINE"))
		{
			System.out.println("hik decline");
			user1.UpdateDdecline(email);
			return "redirect:/donor-home?decline"; 
		}
		else
			return "redirect:/donor-home"; 
		
	}
	
	
@RequestMapping("/hospital/hospital-login")
	public String hospitallogin() {
		return "hospital_login";
	}

	
	
	@RequestMapping("/hospital/hospital-home")
	public String hospitalhome(Model model,@Param("keyword") String keyword) {
		List<Donor> s1;
		
		
		 s1=user1.findAll(keyword);
		 
		 for (Donor donor : s1) {
			System.out.println(donor.getCity()+" hi "+donor.getBloodgroup()+" ");
			model.addAttribute("set"+donor.getD_id(),donor);
		}
	
		model.addAttribute("donors",s1);
		model.addAttribute("keyword",keyword);
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			Hospital h=h1.findByEmail(userDetails.getUsername());
			//model.addAttribute("city",s1);
			// getUsername() - Returns the username used to authenticate the user.
			System.out.println("User name: " + userDetails.getUsername()+" ");

			// getAuthorities() - Returns the authorities granted to the user.
			System.out.println("User has authorities: " + userDetails.getAuthorities()+" "+h1);
			model.addAttribute("name",h.getName());
            model.addAttribute("h",h);
		//model.addAttribute("donors",l);
		return "login1";
	}
	




	public LoginController(DonorDetails user1, HospitalDetails h1) {
		super();
		this.user1 = user1;
		this.h1 = h1;
	}
	
	


}