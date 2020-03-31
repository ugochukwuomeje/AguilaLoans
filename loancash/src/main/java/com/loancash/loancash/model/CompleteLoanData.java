package com.loancash.loancash.model;

public class CompleteLoanData {

	String status;
	String transfer_code;
	CompleteRecipient recipient;
	Long amount;
	
	public CompleteLoanData() {
		
	}

	public CompleteLoanData(String status, String transfer_code, CompleteRecipient recipient, Long amount) {
		
		this.status = status;
		this.transfer_code = transfer_code;
		this.recipient = recipient;
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransfer_code() {
		return transfer_code;
	}

	public void setTransfer_code(String transfer_code) {
		this.transfer_code = transfer_code;
	}

	public CompleteRecipient getRecipient() {
		return recipient;
	}

	public void setRecipient(CompleteRecipient recipient) {
		this.recipient = recipient;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
		
	
}
