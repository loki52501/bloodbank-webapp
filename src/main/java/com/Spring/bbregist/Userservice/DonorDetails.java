package com.Spring.bbregist.Userservice;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;//it is used to authenticate the data retrieved from the database and received data

import com.Spring.bbregist.model.Donor;
import com.Spring.bbregist.web.dto.Donordto;

public interface DonorDetails {
	Donor findByEmail(String email);
	 Donor save(Donordto d,String name); 
	 List<Donor> findAll(String keyword) ;
void deleteByEmail(String mail);
	 List<Donor> findByCity( String keyword);
	

}
