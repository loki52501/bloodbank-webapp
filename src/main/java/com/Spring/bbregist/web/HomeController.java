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
public class HomeController {
	
	
	DonorDetails user1;
	
	
	public HomeController(DonorDetails user1) {
		super();
		this.user1 = user1;
	}
	
	@RequestMapping({"/","/home"})
	public String open() {
		return "home";
	}
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	
	
	


}
