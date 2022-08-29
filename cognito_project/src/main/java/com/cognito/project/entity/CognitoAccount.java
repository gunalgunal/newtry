package com.cognito.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CognitoAccount {

	@Id
	private int accountNumber;
	private long balance;
	public CognitoAccount()
	{
		
	}
	public CognitoAccount(int num,long balance)
	{
		this.accountNumber=num;
		this.balance=balance;
	}
	
	
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber=accountNumber;
	}
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	public void setBalance(long balance)
	{
		this.balance=balance;
	}
	public long getBalance()
	{
		return balance;
	}

}




