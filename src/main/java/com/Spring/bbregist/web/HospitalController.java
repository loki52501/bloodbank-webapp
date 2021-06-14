package com.Spring.bbregist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.bbregist.Userservice.HospitalDetails;

import com.Spring.bbregist.web.dto.Hospitaldao;

@Controller
@RequestMapping("/hospital/hospitalregistration")
public class HospitalController {

	HospitalDetails h1;
	
	
	public HospitalController(HospitalDetails h1) {
		super();
		this.h1 = h1;
	}

	@ModelAttribute("hospital")
	public Hospitaldao donordto()
	{
		return new Hospitaldao();
	}
	@GetMapping
	public String hospitalRegistration(Model model) {
	
		
		return "Register2";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("hospital") Hospitaldao registrationDto)
	 {
		System.out.println(registrationDto+"hhi");
		 h1.save(registrationDto,"Hospital");
		 System.out.println(registrationDto+"hbye");
	 return "redirect:/hospital/hospitalregistration?success";
}	
	
}
