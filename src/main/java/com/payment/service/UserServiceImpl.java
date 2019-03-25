package com.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Account;
import com.payment.model.AddMoney;
import com.payment.model.Transactions;
import com.payment.model.User;
import com.payment.repository.AccountRepository;
import com.payment.repository.TransactionRepository;
import com.payment.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AccountRepository accRepo;
	
	@Autowired
	TransactionRepository trRepo;
	
	@Override
	public List<User> getAllUsers() {
		List<User> userList=userRepo.findAll();
		return userList;
	}

	@Override
	public User getSelfUser() throws com.payment.exception.ResourceNotFoundException {
		//User user=userRepo.findById();
		/*
		 * User user= new User(); user.setEmailId("abc@gmail.com");
		 * user.setFirstName("ABC"); user.setLastName("BAC"); user.setId(1L);
		 * user.setPhoneNumber("1234"); user.setSelf(true);
		 */
		User user=userRepo.findById(1L).orElseThrow(() -> new com.payment.exception.ResourceNotFoundException("user not found for this id"));
		return user;
	}

	@Override
	public User addUser(User user) {
		User user1=userRepo.save(user);
		return user1;
	}

	@Override
	public String addMoney(AddMoney addMoney) throws NumberFormatException, ResourceNotFoundException {
		String fromAccountNumber= addMoney.getFromAccNumber();
		Long amount=addMoney.getTransAmount();
		Account fromAccount=accRepo.findById(new Long(fromAccountNumber)).orElseThrow(() -> new com.payment.exception.ResourceNotFoundException("user not found for this id"));
		long balance=fromAccount.getBalance();
		
		if(balance-amount<0) {
			return "Insufficient Balance in Account :"+fromAccountNumber;
		}else if(amount==0) {
			return "Amount should not be 0. Please enter some amount"; 
		}
		
		long newbalance=balance-amount;
		fromAccount.setBalance(newbalance);
		
		String toAccountNumber=addMoney.getToAccNumber();
		Account toAccount=accRepo.findById(new Long(toAccountNumber)).orElseThrow(() -> new com.payment.exception.ResourceNotFoundException("user not found for this id"));
		long bal = toAccount.getBalance();
		long creditedBal= bal+amount;
		toAccount.setBalance(creditedBal);
		
		accRepo.save(fromAccount);
		accRepo.save(toAccount);

		Transactions tr= new Transactions();
		tr.setAccountNumber(toAccountNumber);
		tr.setBalance(creditedBal);
		tr.setCredit(amount);
		tr.setDebit(0L);
		tr.setTransactionDate(""+System.currentTimeMillis());
		tr.setTransactionDescription("Loan Amount");
		tr.setTransactionStatus("Success");
		
		trRepo.save(tr);
		return addMoney.getAmount()+" Rs. Transfered to Account Number :"+addMoney.getToAccNumber();
				
	}

	
}
