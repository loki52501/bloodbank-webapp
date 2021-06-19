package com.Spring.bbregist.web;

import java.io.IOException;
import java.util.Arrays;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.bbregist.Userservice.DonorDetails;

import com.Spring.bbregist.Userservice.HospitalDetails;
import com.Spring.bbregist.model.ConfirmationToken;
import com.Spring.bbregist.model.Hospital;
import com.Spring.bbregist.model.Role;
import com.Spring.bbregist.repository.ConfirmationTokenRepository;
import com.Spring.bbregist.web.dto.Hospitaldao;


@Controller
public class HospitalController {

	HospitalDetails h1;
	DonorDetails d1;
	
	   @Autowired
	    private ConfirmationTokenRepository confirmationTokenRepository;



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

	@GetMapping("/hospitalregistration")
	public String hospitalRegistration(Model model) {
	
		
		return "Register2";
	}
	@PostMapping("/hospitalregistration")
	public String registerUserAccount(@ModelAttribute("hospital") Hospitaldao registrationDto,BindingResult result) throws AddressException, MessagingException, IOException
	 {
		if(d1.findByEmail(registrationDto.getEmail()) != null || h1.findByEmail(registrationDto.getEmail())!=null)
			result.rejectValue("email", null,"There is already an account registered with the email");
		
		if(result.hasErrors()) {
			return "register2";
			
		}
		else {
			registrationDto.setEnabled(false);
			Hospital user= h1.save(registrationDto,"Hospital");
			
        ConfirmationToken confirmationToken = new ConfirmationToken(user);

        confirmationTokenRepository.save(confirmationToken);

        EmailController t  = new EmailController();
		System.out.println(user.getEmail()+" hi  ");
		String msg="To confirm your account, please click here : "
	            +"http://localhost:3000/confirm-account?token="+confirmationToken.getConfirmationToken();
	
		t.sendmail("splblooddonorfinder@gmail.com",msg);
		
		System.out.println(registrationDto+"hhi");

		 System.out.println(registrationDto+"hbye");
		 
	 return "redirect:/hospitalregistration?success";
}	
	
}
	
	  @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String Token)
	    {

		  ConfirmationToken token1 = confirmationTokenRepository.findByConfirmationt(Token);
     
			 System.out.println(Token+" hbye11 "+ token1.getH().getEmail()+" hurray ");
	     
			 if(token1 != null)
	        {
	        
	     
	            h1.UpdateEnable(token1.getH().getEmail());
	            modelAndView.setViewName("accountVerified");
	        }
	        else
	        {
	            modelAndView.addObject("message","The link is invalid or broken!");
	            modelAndView.setViewName("error");
	        }

	        return modelAndView;
	    }
}