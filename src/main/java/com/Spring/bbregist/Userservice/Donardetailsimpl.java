package com.Spring.bbregist.Userservice;

import com.Spring.bbregist.model.Role;
import com.Spring.bbregist.model.Donor;
import com.Spring.bbregist.repository.DonorRepository;
import com.Spring.bbregist.web.dto.Donordto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Donardetailsimpl  implements DonorDetails {
		
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private DonorRepository userRepository;
	
	public Donardetailsimpl(DonorRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	@Override
public Donor save(Donordto registrationDto, String name) {
	Donor user =new Donor(registrationDto.getFirstname(),registrationDto.getLastname(),registrationDto.getEmail(),registrationDto.getDob()
			,registrationDto.getGender(),registrationDto.getDonated(),registrationDto.getDaccepted(),registrationDto.getAd1(),registrationDto.getAd2(),registrationDto.getState(),registrationDto.getCity(),
			registrationDto.getBloodgroup(),
			registrationDto.getPhno(),passwordEncoder.encode(registrationDto.getPassword()),
			Arrays.asList(new Role(name)),registrationDto.getInvite(),registrationDto.getInvitedate(),registrationDto.getDonateddate());

	return userRepository.save(user);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Donor user= userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password.");
			
		}
	return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	
	}
	
	
private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role>roles){
	return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRollname())).collect(Collectors.toList());
}


@Override
public Donor findByEmail(String email) {
	 
	return userRepository.findByEmail(email);
}

public List<Donor> findAll(String keyword) {
	if(keyword!=null) {
		return userRepository.search(keyword);
	}
	// TODO Auto-generated method stub
	return userRepository.findAll();
}

@Override
public List<Donor> findByCity(String city) {
	// TODO Auto-generated method stub
	return userRepository.findByCity(city);
}


@Override
public void deleteByEmail(String mail) {
	userRepository.deleteByEmail(mail);
}


@Override
public void UpdateInvite(String email) {
 
	userRepository.UpdateInvite(email);
	
}


@Override
public void UpdateInviteany(String email) {
	
	userRepository.UpdateInviteany(email);
	
}


@Override
public void UpdateInvitetime(String email) {
	userRepository.UpdateInvitetime(email);
}


@Override
public void UpdateDonated(String email) {
	userRepository.UpdateDonated(email);
	
}


@Override
public Donor findById(int id) {
	// TODO Auto-generated method stub
	return userRepository.findById(id);
}


@Override
public void UpdateDonatetime(String email) {
userRepository.UpdateDonatetime(email);
	
}


@Override
public void UpdateDaccept(String email) {
	userRepository.UpdateDaccept(email);
	
}


@Override
public void UpdateDonatedfirst(String email) {
userRepository.UpdateDonatedfirst(email);
	
}


@Override
public void UpdateDdecline(String email) {
	userRepository.UpdateDdecline(email);
	
}




}