package com.loancash.loancash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transfer")
public class TransferResponse {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="success")
	String success;
	
	@Column(name="message")
	String message;
	
	@Column(name="accountnumber")
	String accountnumber;
	
	@Column(name="bankcode")
	String bankcode;
	
	@Column(name="fullname")
	String fullname;
	
	@Column(name="date")
	String date;
	
	@Column(name="currency")
	String currency;
	
	@Column(name="amount")
	String amount;
	
	@Column(name="fee")
	String fee;
	
	@Column(name="status")
	String status;
	
	@Column(name="bankname")
	String bankname;

	public TransferResponse(String success, String message, String accountnumber, String bankcode, String fullname,
			String date, String currency, String amount, String fee, String status, String bankname) {
		
		this.success = success;
		this.message = message;
		this.accountnumber = accountnumber;
		this.bankcode = bankcode;
		this.fullname = fullname;
		this.date = date;
		this.currency = currency;
		this.amount = amount;
		this.fee = fee;
		this.status = status;
		this.bankname = bankname;
	}

	public TransferResponse() {
		
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	
}
