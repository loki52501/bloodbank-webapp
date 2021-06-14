package com.Spring.bbregist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roleh", schema="blood_bank_registry")
public class Roleh {

	public Long getHr_id() {
		return hr_id;
	}
	public void setHr_id(Long hr_id) {
		this.hr_id = hr_id;
	}
	public String getHrollname() {
		return hrollname;
	}
	public void setHrollname(String hrollname) {
		this.hrollname = hrollname;
	}
	public Roleh() {
		super();
	}
	public Roleh( String hrollname) {
		super();
		this.hrollname = hrollname;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long hr_id;
	
	
private String hrollname;





}