package com.loancash.loancash.model;

public class CompleteRecipient {
	
	CompleteLoanAccountDetails details;

	public CompleteRecipient(CompleteLoanAccountDetails details) {
		
		this.details = details;
	}

	public CompleteLoanAccountDetails getDetails() {
		return details;
	}

	public void setDetails(CompleteLoanAccountDetails details) {
		this.details = details;
	}
	
	
}
