package com.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.model.Account;
import com.payment.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accRepo;
	
	@Override
	public List<Account> getAllAccounts() {
		List<Account> payeeList= accRepo.findAll();
		return payeeList;
	}
}
