package com.payment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCOUNTNUMBER")
	private Long acctNumber;
	
	@Column(name="BALANCE")
	private Long balance;
	
	public Account() {
		
	}
	public Long getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(Long acctNumber) {
		this.acctNumber = acctNumber;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "["+"acctNumber"+acctNumber+"balance"+balance+"]";
	}
	
}
