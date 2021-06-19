package com.Spring.bbregist.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.bbregist.Userservice.DonorDetails;
import com.Spring.bbregist.Userservice.HospitalDetails;
import com.Spring.bbregist.web.dto.Donordto;

@Controller
@RequestMapping("/donorregistration")
public class DonorregistController {
	

	private DonorDetails d1;
	private HospitalDetails h1;
	 private static ArrayList<String> bloodtype;

	 static {
			bloodtype = new ArrayList<>();
			bloodtype.add("A+ve");
			bloodtype.add("B+ve");
			bloodtype.add("O+ve");
			bloodtype.add("AB+ve");
			bloodtype.add("AB-ve");
			bloodtype.add("O-ve");
			bloodtype.add("B-ve");
			bloodtype.add("A-ve");
		}





	public DonorregistController(DonorDetails d1, HospitalDetails h1) {
		super();
		this.d1 = d1;
		this.h1 = h1;
	}

	@ModelAttribute("donor")
	public Donordto donordto()
	{
		return new Donordto();
	}
	
	@GetMapping
	public String register(Model model) {
	
		model.addAttribute("bloodtype", bloodtype);
		return "register1";
	}

	@PostMapping
 public String registerUserAccount(@ModelAttribute("donor") Donordto registrationDto, BindingResult result)
	 {
		if(d1.findByEmail(registrationDto.getEmail()) != null||  h1.findByEmail(registrationDto.getEmail())!=null) 
			result.rejectValue("email", null,"There is already an account registered with the email");
		

		if(result.hasErrors()) {
			return "register1";
			
		}
		
		
		
		System.out.println(registrationDto+"hi");
		
		
		
		
		 d1.save(registrationDto,"Donor");
		 System.out.println(registrationDto+"bye");
	
	 System.out.println("redirect:/donorregistration?success");
	 return "redirect:/donorregistration?success";
}	
}
