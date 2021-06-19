package com.Spring.bbregist.model;

import javax.persistence.*;

@Entity
@Table(name="role", schema="spl")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long r_id;
private String rollname;
public Role(String rollname) {
	super();
	this.rollname = rollname;
}
public Long getR_id() {
	return r_id;
}
public void setR_id(Long r_id) {
	this.r_id = r_id;
}
public String getRollname() {
	return rollname;
}
public void setRollname(String rollname) {
	this.rollname = rollname;
}
public Role() {
	super();
}

}
