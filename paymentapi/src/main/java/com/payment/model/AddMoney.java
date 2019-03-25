package com.payment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AddMoney")
public class AddMoney implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="fromAccountNumber")
	private String fromAccNumber;
		
	@Column(name="toAccountNumber")
	private String toAccNumber;

	@Id
	@Column(name="amount")
	private Long transAmount;
	
	@Column(name="description")
	private String description;

	public String getFromAccNumber() {
		return fromAccNumber;
	}

	public void setFromAccNumber(String fromAccNumber) {
		this.fromAccNumber = fromAccNumber;
	}

	public String getToAccNumber() {
		return toAccNumber;
	}

	public void setToAccNumber(String toAccNumber) {
		this.toAccNumber = toAccNumber;
	}

	public Long getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(Long transAmount) {
		this.transAmount = transAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
