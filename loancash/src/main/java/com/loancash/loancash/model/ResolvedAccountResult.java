package com.loancash.loancash.model;

public class ResolvedAccountResult {

	boolean status;
	
	String message;
	
	ResolvedAccountName data;
		
	public ResolvedAccountResult() {
		
	}

	public ResolvedAccountResult(boolean status, String message, ResolvedAccountName data) {
	
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResolvedAccountName getData() {
		return data;
	}

	public void setData(ResolvedAccountName data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResolvedAccountResult [status=" + status + ", message=" + message + ", data=" + data + "]";
	}

	
}
