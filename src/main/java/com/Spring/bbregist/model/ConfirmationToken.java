
package com.Spring.bbregist.model;

import javax.persistence.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="ConfirmationToken",schema="spl")
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;

    @Column(name="confirmation_token")
    private String confirmationt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Hospital.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "h_id")
    private Hospital h;

    public ConfirmationToken(Hospital user) {
        this.h = user;
        createdDate = new Date();
        confirmationt= UUID.randomUUID().toString();
    }







	public ConfirmationToken() {
		super();
	}




	public ConfirmationToken(String confirmationToken) {
		super();
		this.confirmationt = confirmationToken;
	}

	public long getTokenid() {
		return tokenid;
	}

	public void setTokenid(long tokenid) {
		this.tokenid = tokenid;
	}

	public String getConfirmationToken() {
		return confirmationt;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationt = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Hospital getH() {
		return h;
	}

	public void setH(Hospital h) {
		this.h = h;
	}

    // getters and setters
}