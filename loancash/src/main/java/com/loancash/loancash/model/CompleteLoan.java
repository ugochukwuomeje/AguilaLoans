package com.loancash.loancash.model;

public class CompleteLoan {

	String event;
	CompleteLoanData data;
	
	public CompleteLoan() {
	
	}
		
	public CompleteLoan(String event, CompleteLoanData completeloandata) {
	
		this.event = event;
		this.data = completeloandata;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public CompleteLoanData getCompleteloandata() {
		return data;
	}

	public void setCompleteloandata(CompleteLoanData completeloandata) {
		this.data = completeloandata;
	}

	@Override
	public String toString() {
		return "CompleteLoan [event=" + event + ", completeloandata=" + data + "]";
	}

	
	
}
