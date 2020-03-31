package com.loancash.loancash.model;

public class PaymentData {

	int id;
	
	double amount;
	
	String createdAt;
	
	String updatedAt;
		
	String transfer_code;
	
	String status;
		
	public PaymentData(int id, double amount, String createdAt, String updatedAt, String transfer_code, String status) {
		
		this.id = id;
		this.amount = amount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.transfer_code = transfer_code;
		this.status = status;
		
	}
	
	public PaymentData() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUdatedAt() {
		return updatedAt;
	}

	public void setUdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTransfer_code() {
		return transfer_code;
	}

	public void setTransfer_code(String transfer_code) {
		this.transfer_code = transfer_code;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentData [id=" + id + ", amount=" + amount + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", transfer_code=" + transfer_code + ", status=" + status + "]";
	}

	
}
