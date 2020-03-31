package com.loancash.loancash.model;

public class ResolvedAccountName {

	String account_number;
	
	String account_name;
	
	public ResolvedAccountName() {
		
	}

	public ResolvedAccountName(String account_number, String account_name) {
		
		this.account_number = account_number;
		this.account_name = account_name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	@Override
	public String toString() {
		return "ResolvedAccountName [account_number=" + account_number + ", account_name=" + account_name + "]";
	}

	
	
}
