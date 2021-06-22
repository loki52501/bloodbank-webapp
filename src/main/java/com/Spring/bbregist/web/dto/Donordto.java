package com.Spring.bbregist.web.dto;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.Spring.bbregist.model.Donor;
import com.Spring.bbregist.model.Role;
import com.sun.istack.NotNull;

public class Donordto {

	private Long d_id;


	private String firstname;


	private String lastname;


	private String email;


	private String ad1;


	private String ad2;

    private String gender;
    
    private Long donated;
	

private Long invite;

@NotNull
private LocalDate invitedate;

private LocalDate donateddate;


@NotNull
@Column(name="daccepted")
private Long daccepted;


public Long getDaccepted() {
	return daccepted;
}

public void setDaccepted(Long daccepted) {
	this.daccepted = daccepted;
}

public Donordto(String firstname, String lastname, String email, String ad1, String ad2, String gender, Long donated,
		Long invite, LocalDate invitedate, LocalDate donateddate, Long daccepted, String state, String city,
		String bloodgroup, Long phno, Date dob, String password, Collection<Role> roles) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.gender = gender;
	this.donated = donated;
	this.invite = invite;
	this.invitedate = invitedate;
	this.donateddate = donateddate;
	this.daccepted = daccepted;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.dob = dob;
	this.password = password;
	this.roles = roles;
}

public LocalDate getDonateddate() {
	return donateddate;
}

public void setDonateddate(LocalDate donateddate) {
	this.donateddate = donateddate;
}

public Donordto(String firstname, String lastname, String email, String ad1, String ad2, String gender, Long donated,
		Long invite, LocalDate invitedate, LocalDate donateddate, String state, String city, String bloodgroup,
		Long phno, Date dob, String password, Collection<Role> roles) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.gender = gender;
	this.donated = donated;
	this.invite = invite;
	this.invitedate = invitedate;
	this.donateddate = donateddate;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.dob = dob;
	this.password = password;
	this.roles = roles;
}

public Donordto(Donor d) {
	
	this.firstname = d.getFirstname();
	this.lastname = d.getLastname();
	this.email = d.getEmail();
	this.ad1 = d.getAd1();
	this.ad2 = d.getAd2();
	this.gender = d.getGender();
	this.invite = d.getInvite();
	this.state = d.getState();
	this.city =d.getCity();
	this.bloodgroup = d.getBloodgroup();
	this.phno = d.getPhno();
	this.dob = d.getDob();
	this.password = d.getPassword();
	this.roles = d.getRoles();
	this.invitedate=d.getInvitedate();
	
}

	public LocalDate getInvitedate() {
	return invitedate;
}

public void setInvitedate(LocalDate invitedate) {
	this.invitedate = invitedate;
}

	public Donordto(String firstname, String lastname, String email, String ad1, String ad2, String gender, 
		Long invite, String state, String city, String bloodgroup, Long phno, Date dob, String password,
		List<Role> roles) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.gender = gender;
	this.invite = invite;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.dob = dob;
	this.password = password;
	this.roles = roles;
}

	public Long getInvite() {
		return invite;
	}

	public void setInvite(Long invite) {
		this.invite = invite;
	}

	private String state;


	private String city;


	private String bloodgroup;


	private Long phno;


	private Date dob;


	private String password;

	
	Collection<Role> roles;

	public Donordto(String firstname, String lastname, String email, String ad1, String ad2, String state,
			String city, String bloodgroup, Long phno, Date dob, String password,
			Collection<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.ad1 = ad1;
		this.ad2 = ad2;

		this.state = state;
		this.city = city;
		this.bloodgroup = bloodgroup;
		this.phno = phno;
		this.dob = dob;
		this.password = password;
		this.roles = roles;
	}

	public Donordto(String firstname, String lastname, String email, String ad1, String ad2, String gender, Long donated,
			String state, String city, String bloodgroup, Long phno, Date dob, String password, Collection<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.ad1 = ad1;
		this.ad2 = ad2;
		this.gender = gender;
		this.donated = donated;
		this.state = state;
		this.city = city;
		this.bloodgroup = bloodgroup;
		this.phno = phno;
		this.dob = dob;
		this.password = password;
		this.roles = roles;
	}

	public Donordto(String firstname, String lastname, String email, String ad1, String ad2, String gender,
			String state, String city, String bloodgroup, Long phno, Date dob, String password, Collection<Role> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.ad1 = ad1;
		this.ad2 = ad2;
		this.gender = gender;
		this.state = state;
		this.city = city;
		this.bloodgroup = bloodgroup;
		this.phno = phno;
		this.dob = dob;
		this.password = password;
		this.roles = roles;
	}

	public Donordto() {
		
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getDonated() {
		return donated;
	}

	public void setDonated(Long donated) {
		this.donated = donated;
	}

	public Long getD_id() {
		return d_id;
	}

	public void setD_id(Long d_id) {
		this.d_id = d_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAd1() {
		return ad1;
	}

	public void setAd1(String ad1) {
		this.ad1 = ad1;
	}

	public String getAd2() {
		return ad2;
	}

	public void setAd2(String ad2) {
		this.ad2 = ad2;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


		
	}