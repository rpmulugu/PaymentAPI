package com.payment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transactions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * "TransactionID": "58", "AccountNumber": "30", "TransactionDate":
	 * "3/22/2019 5:53:22 AM", "Credit": "0", "Debit": "100", "Balance": "-3424",
	 * "TransactionStatus": "Sucess", "TransactionDescription": "Loan amount"
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TRANSACTION_ID")
	public Long TransactionID;
	
	@Column(name="ACCOUNT_NUMBER")
	public String AccountNumber;
	
	@Column(name="TRANSACTION_DATE")
	public String TransactionDate;
	
	@Column(name="CREDIT")
	public Long Credit;
	
	@Column(name="DEBIT")
	public Long Debit;
	
	@Column(name="BALANCE")
	public Long Balance;
	
	@Column(name="TRANSACTION_STATUS")
	public String TransactionStatus;
	
	@Column(name="TRANSACTION_DESCRIPTION")
	public String TransactionDescription;

	public Long getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.TransactionID = transactionID;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.AccountNumber = accountNumber;
	}

	public String getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.TransactionDate = transactionDate;
	}

	public Long getCredit() {
		return Credit;
	}

	public void setCredit(Long credit) {
		this.Credit = credit;
	}

	public Long getDebit() {
		return Debit;
	}

	public void setDebit(Long debit) {
		this.Debit = debit;
	}

	public Long getBalance() {
		return Balance;
	}

	public void setBalance(Long balance) {
		this.Balance = balance;
	}

	public String getTransactionStatus() {
		return TransactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.TransactionStatus = transactionStatus;
	}

	public String getTransactionDescription() {
		return TransactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.TransactionDescription = transactionDescription;
	}
	
	
}
