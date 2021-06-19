package com.Spring.bbregist.web.dto;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.Spring.bbregist.model.Hospital;
import com.Spring.bbregist.model.Role;

public class Hospitaldao {

	private Long h_id;


	private String name;


	private String email;

	private String city;


	private String bloodgroupneeded;


	private Long phno;
	
	private String password;

	Collection<Role> roles;
	
 private boolean isEnabled;

	public boolean isEnabled() {
		return isEnabled;
	}


	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Hospitaldao() {
		super();
	}

	
	
	public Hospitaldao(Hospital h) {
		super();
	
		this.name = h.getName();
		this.email = h.getEmail();
		this.city = h.getCity();
		this.phno = h.getPhno();
		this.password = h.getPassword();
		this.roles = h.getRoles();
		this.isEnabled=h.isEnabled();
	
	}
	
	
	
	
	public Hospitaldao(String name, String email, String city, Long phno, String password, Collection<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.phno = phno;
		this.password = password;
		this.roles = roles;
	}

	public Hospitaldao(String name, String email, String city, String bloodgroupneeded, Long phno, String password,
			Collection<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.bloodgroupneeded = bloodgroupneeded;
		this.phno = phno;
		this.password = password;
		this.roles = roles;
	}

	public Long getH_id() {
		return h_id;
	}

	public void setH_id(Long h_id) {
		this.h_id = h_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBloodgroupneeded() {
		return bloodgroupneeded;
	}

	public void setBloodgroupneeded(String bloodgroupneeded) {
		this.bloodgroupneeded = bloodgroupneeded;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	

}