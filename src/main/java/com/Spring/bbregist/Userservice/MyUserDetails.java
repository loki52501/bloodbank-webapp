package com.Spring.bbregist.Userservice;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.users.AbstractUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Spring.bbregist.model.Donor;
import com.Spring.bbregist.model.Hospital;
import com.Spring.bbregist.model.Role;
import com.Spring.bbregist.repository.DonorRepository;
import com.Spring.bbregist.repository.HospitalRepository;

@Service
public class MyUserDetails implements MyUserDetailService {

	@Autowired
	private DonorRepository donorRepository;

@Autowired
private HospitalRepository hospitalRepository;

	public MyUserDetails() {
		super();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional<Donor> d=donorRepository.findByemail(username);
		
		Optional<Hospital> h=hospitalRepository.findByemail(username);
         
        int flag=0;
if(d.isPresent())
{
	System.out.println("hi"+ d.get().getFirstname());
	flag=1;
}
else if(h.isPresent())
{

	System.out.println("hi h "+h.get().getName());
	flag=2;
}
      if(d.isEmpty() && h.isEmpty()) {
    	  throw new UsernameNotFoundException("Entered username is not available");
      }
      
      else if(flag==1)
    	  return new org.springframework.security.core.userdetails.User(d.get().getEmail(),d.get().getPassword(),mapRolesToAuthorities(d.get().getRoles()));
	
      else
    	  return new org.springframework.security.core.userdetails.User(h.get().getEmail(),h.get().getPassword(),mapRolesToAuthorities(h.get().getRoles()));
			

	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role>roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRollname())).collect(Collectors.toList());
		}



}
