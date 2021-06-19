package com.Spring.bbregist.Userservice;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Spring.bbregist.model.Hospital;
import com.Spring.bbregist.model.Role;

import com.Spring.bbregist.repository.HospitalRepository;
import com.Spring.bbregist.web.dto.Hospitaldao;


@Service
public class Hospitaldetailsimpl implements HospitalDetails {
	
@Autowired
BCryptPasswordEncoder passwordEncoder;

@Autowired
private HospitalRepository userRepository;

public Hospitaldetailsimpl(HospitalRepository userRepository) {
	super();
	this.userRepository = userRepository;
}


@Override
public Hospital save(Hospitaldao registrationDto, String name)  {
Hospital user =new Hospital(registrationDto.getName(),registrationDto.getEmail(),registrationDto.getCity(),registrationDto.getPhno(),passwordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Role(name)));
    return userRepository.save(user);
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	Hospital user= userRepository.findByEmail(username);

	if(user==null||user.isEnabled()==false) {
		System.out.print(userRepository.findAll().size()+"hiii ");
		throw new UsernameNotFoundException("Invalid username or password.");
		
	}
	System.out.print(user.getEmail()+" "+user.getPassword()+" ");
return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));

}


private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role>roles){
return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRollname())).collect(Collectors.toList());
}

@Override
public Hospital findByEmail(String email) {
	
	return userRepository.findByEmail(email);
}
@Override
public void UpdateEnable(String email) {
	userRepository.UpdateEnable(email);
	
}


}
