package com.loancash.loancash.model;

public class TransferReceipientCode {

	String nuban;
	
	public TransferReceipientCode() {
	
	}

	public TransferReceipientCode(String nuban) {
		
		this.nuban = nuban;
	}


	public String getRecipient_code() {
		return nuban;
	}

	public void setRecipient_code(String nuban) {
		this.nuban = nuban;
	}

	
}
