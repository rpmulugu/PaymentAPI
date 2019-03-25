package com.payment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;	
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNumber;
	
	
	 
	public User() {
		
	}
	public User(long id,  String firstName,
	String lastName,
	String emailId,
	String phoneNumber) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.emailId=emailId;
		this.phoneNumber=phoneNumber;
	}
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY,mappedBy="acctNumber",cascade =
	 * CascadeType.ALL)
	 * 
	 * @Column(name="ACCT_ID") private Account acct;
	 */
	private boolean isSelf;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	/*
	 * public Account getAcct() { return acct; }
	 * 
	 * public void setAcct(Account acct) { this.acct = acct; }
	 */
	@Column(name="ISSELF")
	public boolean isSelf() {
		return isSelf;
	}
	public void setSelf(boolean isSelf) {
		this.isSelf = isSelf;
	}
	@Column(name="FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LASTNAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="EMAILID")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name="PHONENUMBER")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId+", phoneNumber="+phoneNumber+ "]";
				//", accountNumber ="+acct
				
	}
	
}
