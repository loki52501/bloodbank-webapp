package com.Spring.bbregist.model;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.Spring.bbregist.web.dto.Donordto;
import com.sun.istack.NotNull;


@Entity
@Table(name="donor",schema="spl")
public class Donor {
@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
private Long d_id;

@NotNull
@Column(name="fname")
private String firstname;

@NotNull
@Column(name="lname")
private String lastname;

@NotNull
@Column(name="email",unique = true)
private String email;

@NotNull
@DateTimeFormat(pattern = "dd-MM-yyyy")
@Column(name="dob")
private Date dob;

@NotNull
@Column(name="gender")
private String gender;

@NotNull
@Column(name="donated")
private Long donated;

@NotNull
@Column(name="daccepted")
private Long daccepted;


public Donor() {
	super();
	donated=(long) 0;
	invite=(long) 0;
}

@NotNull
@Column(name="address1")
private String ad1;

@NotNull
@Column(name="address2")
private String ad2;


@NotNull
@Column(name="state")
private String state;

@NotNull
@Column(name="city")
private String city;


@NotNull
@Column(name="bg")
private String bloodgroup;

@NotNull
@Column(name="phno")
private Long phno;



@Column(name="password")
private String password;

@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)//implemented to keep track of parent(user) and child(role) entity
@JoinTable(name = "user_ROLES",schema="spl",
joinColumns = @JoinColumn(name = "d_id"), 
inverseJoinColumns = @JoinColumn(name = "r_id"))
Collection<Role> roles;

@NotNull
private Long invite;

@NotNull
private LocalDate invitedate;

@NotNull
private LocalDate donateddate;

public Long getDaccepted() {
	return daccepted;
}


public void setDaccepted(Long daccepted) {
	this.daccepted = daccepted;
}


public Donor(String firstname, String lastname, String email, Date dob, String gender, Long donated, Long daccepted,
		String ad1, String ad2, String state, String city, String bloodgroup, Long phno, String password,
		Collection<Role> roles, Long invite, LocalDate invitedate, LocalDate donateddate) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.donated = donated;
	this.daccepted = daccepted;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.password = password;
	this.roles = roles;
	this.invite = invite;
	this.invitedate = invitedate;
	this.donateddate = donateddate;
}


public Donor(String firstname, String lastname, String email, Date dob, String gender, Long donated, String ad1,
		String ad2, String state, String city, String bloodgroup, Long phno, String password, Collection<Role> roles,
		Long invite, LocalDate invitedate, LocalDate donateddate) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.donated = donated;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.password = password;
	this.roles = roles;
	this.invite = invite;
	this.invitedate = invitedate;
	this.donateddate = donateddate;
}


public LocalDate getDonateddate() {
	return donateddate;
}


public void setDonateddate(LocalDate donateddate) {
	this.donateddate = donateddate;
}


public LocalDate getInvitedate() {
	return invitedate;
}


public void setInvitedate(LocalDate invitedate) {
	this.invitedate = invitedate;
}


public Donor(String firstname, String lastname, String email, Date dob, String gender,Long donated, String ad1,
		String ad2, String state, String city, String bloodgroup, Long phno, String password, Collection<Role> roles,
		Long invite, LocalDate invitedate) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.donated = donated;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.password = password;
	this.roles = roles;
	this.invite = invite;
	this.invitedate = invitedate;
}


public Donor(Donor d)
{
	this.firstname = d.getFirstname();
	this.lastname = d.getLastname();
	this.email = d.getEmail();
	this.dob =d.getDob();
	this.gender = d.getGender();
	this.ad1 = d.getAd1();
	this.ad2 = d.getAd2();
	this.state = d.getState();
	this.city = d.getCity();
	this.bloodgroup = d.getBloodgroup();
	this.phno = d.getPhno();
	this.password = d.getPassword();
	this.roles = d.getRoles();
	this.invite = d.getInvite();
}


public Donor(String firstname, String lastname, String email, Date dob, String gender, String ad1, String ad2,
		String state, String city, String bloodgroup, Long phno, String password, Collection<Role> roles,
		Long invite) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.password = password;
	this.roles = roles;
	this.invite = invite;
}

public Long getInvite() {
	return invite;
}

public void setInvite(Long invite) {
	this.invite = invite;
}

public Donor(String firstname, String lastname, String email, Date dob, String gender, Long donated, String ad1,
		String ad2, String state, String city, String bloodgroup, Long phno, String password, Collection<Role> roles) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.donated = donated;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.password = password;
	this.roles = roles;
}

public Donor(String firstname, String lastname, String email, String ad1, String ad2, String state,
		String city, String bloodgroup, Long phno, Date dob, String password, Collection<Role> roles) {
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

public Donor(String firstname, String lastname, String email, Date dob, String gender, String ad1, String ad2,
		String state, String city, String bloodgroup, Long phno, String password, Collection<Role> roles) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.ad1 = ad1;
	this.ad2 = ad2;
	this.state = state;
	this.city = city;
	this.bloodgroup = bloodgroup;
	this.phno = phno;
	this.password = password;
	this.roles = roles;
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
