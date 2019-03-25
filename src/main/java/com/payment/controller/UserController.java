package com.payment.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.payment.exception.ResourceNotFoundException;
import com.payment.model.Account;
import com.payment.model.AddMoney;
import com.payment.model.Transactions;
import com.payment.model.User;
import com.payment.repository.UserRepository;
import com.payment.service.AccountService;
import com.payment.service.TransactionService;
import com.payment.service.UserService;
import java.lang.RuntimeException;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	TransactionService trService;

	@GetMapping("/Accounts")
	public String getAllAccounts(){
		List<Account> payeeAccounts=accountService.getAllAccounts();
		String accountList="[";
		int i=0;
		for(Account a : payeeAccounts) {
			accountList+="\n"+a.getAcctNumber().toString();
			if(i<payeeAccounts.size()-1) {
				accountList+=",";
			}
			i++;
		}		
		return accountList+"\n]";
	}
	
	@GetMapping("/Users")
	public List<User> getAllUsers() {
		List<User> userList=userService.getAllUsers();
		return userList;
	}
	
	@GetMapping("/User")
	public Long getSelfUser() throws ResourceNotFoundException {
		User user= userService.getSelfUser();
		return user.getId();
	}
		
	@PostMapping("/User")
	public Long addUser(@RequestBody User user) {
		//int count=
		User user1=userService.addUser(user);
		 
		 if (user1!=null) return user1.getId();//+user1.getAcct().getAcctNumber(); 
				 //ResponseEntity.noContent().build();
		 
		 throw new RuntimeException("Error adding user");
		/*
		 * URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
		 * "").buildAndExpand(user.getId()).toUri();
		 */
		 
		//return ResponseEntity.created(location).build();

	}
	
	@PostMapping("/transact")
	public String addMoney(@RequestBody AddMoney addMoney) throws NumberFormatException, ResourceNotFoundException
	{
		String response=userService.addMoney(addMoney);
		
		return response;
	}
	
	@GetMapping("/Transactions")
	public List<Transactions> getAllTransactions(){
		List<Transactions> trList= trService.getAllTransactions();
		return trList;
	}
}
