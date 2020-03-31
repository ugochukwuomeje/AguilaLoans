package com.loancash.loancash.model;

public class TransferModel {

	private boolean status;
	private String message;
	private PaymentData data;
			
	public TransferModel() {
		
	}

	
	
	public TransferModel(boolean status, String message, PaymentData data) {
		
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

	public PaymentData getData() {
		return data;
	}

	public void setData(PaymentData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TransferModel [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
