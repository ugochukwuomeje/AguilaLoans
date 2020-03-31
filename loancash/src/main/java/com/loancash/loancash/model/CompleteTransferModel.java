package com.loancash.loancash.model;

public class CompleteTransferModel {

	String amountborrorwed;
	String requestdate;
	String amounttopay;
	String phonenumber;
	String transferreceipient;
	String interest;
	String loanterm;
	
	public CompleteTransferModel(String amountborrorwed, String requestdate, String amounttopay, String phonenumber,
			String transferreceipient, String interest, String loanterm) {
		
		this.amountborrorwed = amountborrorwed;
		this.requestdate = requestdate;
		this.amounttopay = amounttopay;
		this.phonenumber = phonenumber;
		this.transferreceipient = transferreceipient;
		this.interest = interest;
		this.loanterm = loanterm;
	}

	public CompleteTransferModel() {
	
	}

	public String getAmountborrorwed() {
		return amountborrorwed;
	}

	public void setAmountborrorwed(String amountborrorwed) {
		this.amountborrorwed = amountborrorwed;
	}

	public String getRequestdate() {
		return requestdate;
	}

	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}

	public String getAmounttopay() {
		return amounttopay;
	}

	public void setAmounttopay(String amounttopay) {
		this.amounttopay = amounttopay;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getTransferreceipient() {
		return transferreceipient;
	}

	public void setTransferreceipient(String transferreceipient) {
		this.transferreceipient = transferreceipient;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getLoanterm() {
		return loanterm;
	}

	public void setLoanterm(String loanterm) {
		this.loanterm = loanterm;
	}

	
}
