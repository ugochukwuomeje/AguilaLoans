package com.loancash.loancash.model;

public class TransferReceipientModel {

	boolean status;
	
	String message;
	
	TransferReceipientCode data;
	
	
	public TransferReceipientModel() {
		
	}

	public TransferReceipientModel(boolean status, String message, TransferReceipientCode data) {
		
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

	public TransferReceipientCode getData() {
		return data;
	}

	public void setData(TransferReceipientCode data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TransferReceipientModel [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
		
	
}
