package com.loancash.loancash.model;

public class CompleteLoanAccountDetails {
	
	String account_number;
    String account_name;
    String bank_name;
    
	public CompleteLoanAccountDetails(String account_number, String account_name, String bank_name) {

		this.account_number = account_number;
		this.account_name = account_name;
		this.bank_name = bank_name;
	}
		
	public CompleteLoanAccountDetails() {
		super();
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

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
    
    

}
