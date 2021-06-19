package com.Spring.bbregist.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hospital",schema="spl")
public class Hospital {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long h_id;

	@Column(name="name")
	private String name;

	 
	@Column(name="email",unique = true)
	private String email;

	@Column(name="city")
	private String city;

	@Column(name="bgneeded")
	private String bloodgroupneeded;

	@Column(name="phno")
	private Long phno;

	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)//implemented to keep track of parent(user) and child(role) entity
	@JoinTable(name = "hospital_ROLES",schema="spl",
	joinColumns = @JoinColumn(name = "h_id"), 
	inverseJoinColumns = @JoinColumn(name = "r_id"))
	Collection<Role> roles;
	
	@Column(name="enabled")
	  private boolean isEnabled;

	public boolean isEnabled() {
		return isEnabled;
	}


	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


	public Hospital() {
		super();
		
	}


public Hospital(String name, String email, String city,  Long phno, String password,
			Collection<Role> roles, boolean isEnabled) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		
		this.phno = phno;
		this.password = password;
		this.roles = roles;
		this.isEnabled = isEnabled;
	}


public Hospital(Hospital h) {
	this.h_id = h.getH_id();
	this.name = h.getName();
	this.email = h.getEmail();
	this.city = h.getCity();
	this.bloodgroupneeded = h.getBloodgroupneeded();
	this.phno = h.getPhno();
	this.password = h.getPassword();
	this.roles = h.getRoles();
}



	public Hospital(Long h_id, String name, String email, String city, String bloodgroupneeded, Long phno,
			String password, Collection<Role> roles) {
		super();
		this.h_id = h_id;
		this.name = name;
		this.email = email;
		this.city = city;
		this.bloodgroupneeded = bloodgroupneeded;
		this.phno = phno;
		this.password = password;
		this.roles = roles;
	}



	public Hospital(String name, String email, String city, Long phno, String password, Collection<Role> roles) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.phno = phno;
		this.password = password;
		this.roles = roles;
	}



	public Hospital(String name, String email, String city, String bloodgroupneeded, Long phno, String password,
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