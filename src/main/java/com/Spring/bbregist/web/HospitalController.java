package com.Spring.bbregist.web;

import javax.servlet.Registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.bbregist.Userservice.DonorDetails;
import com.Spring.bbregist.Userservice.HospitalDetails;

import com.Spring.bbregist.web.dto.Hospitaldao;

@Controller
@RequestMapping("/hospitalregistration")
public class HospitalController {

	HospitalDetails h1;
	DonorDetails d1;
	


	public HospitalController(HospitalDetails h1, DonorDetails d1) {
		super();
		this.h1 = h1;
		this.d1 = d1;
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
	public String registerUserAccount(@ModelAttribute("hospital") Hospitaldao registrationDto,BindingResult result)
	 {
		if(d1.findByEmail(registrationDto.getEmail()) != null || h1.findByEmail(registrationDto.getEmail())!=null)
			result.rejectValue("email", null,"There is already an account registered with the email");
		
		if(result.hasErrors()) {
			return "register2";
			
		}
		
		
		
		System.out.println(registrationDto+"hhi");
		 h1.save(registrationDto,"Hospital");
		 System.out.println(registrationDto+"hbye");
		 
	 return "redirect:/hospitalregistration?success";
}	
	
}
