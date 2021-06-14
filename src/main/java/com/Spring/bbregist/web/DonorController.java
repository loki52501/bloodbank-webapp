package com.Spring.bbregist.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.bbregist.Userservice.DonorDetails;

@Controller
@RequestMapping
public class DonorController {
	
	
	DonorDetails user1;
	
	@GetMapping("/donorlogin")
	public String donorlogin() {
		return "user_login";
	}
	
	
	@GetMapping("/donor-home")
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
	return "login";
	}
	public DonorController(DonorDetails user1) {
		super();
		this.user1 = user1;
	}
	
	@GetMapping("/")
	public String open() {
		return "home";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	
	
	


}
