package com.Spring.bbregist.Userservice;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Spring.bbregist.model.Hospital;
import com.Spring.bbregist.web.dto.Hospitaldao;

public interface HospitalDetails extends UserDetailsService{ 
	
	
	Hospital save(Hospitaldao h, String name);
	
	
	Hospital findByEmail(String email);

}
