package com.cognito.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognito.project.entity.CognitoAccount;



@Component
public class CognitoService {
	
	@Autowired
	private CognitoRepository repository;
	

    public long balance(int number)
	{
		Optional<CognitoAccount> account=repository.findById(number);
		return account.get().getBalance();
	}
	
	public String withdraw(long amount,int number)
	{
		Optional<CognitoAccount> account=repository.findById(number);
		if(account.get().getBalance()>amount)
		{
			repository.save(new CognitoAccount(number,account.get().getBalance()-amount));
			return String.valueOf(balance(number));
		}
		
		  return "withdraw amount is greater than balance amount:try again!";
	}
	public long deposit(long amount,int number)
	{
		
		Optional<CognitoAccount> account=repository.findById(number);
	    amount=amount+account.get().getBalance();
	    repository.save(new CognitoAccount(number,amount));
	    return amount;
	}
	public void add(int number,long amount)
	{
		repository.save(new CognitoAccount(number,amount));
		
	}
	

}
