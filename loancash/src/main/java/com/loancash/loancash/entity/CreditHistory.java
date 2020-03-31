package com.loancash.loancash.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="credithistory")
public class CreditHistory {

	@Id
	@Column(name="id")
	@GeneratedValue()
	int id;
	
	@ManyToOne(cascade= {CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="phonenumber")
	PhoneNumbers phonenumber;
	
	@Column(name="amountborrowed")
	String AmountBorrowed;
		
	@Column(name="requestdate")
	String RequsetDate;
	
	@Column(name="interest")
	String Interest;
	
	@Column(name="amounttopay")
	String AmountToPay;
	
	@Column(name="duedate")
	String DueDate;
	
	@Column(name="borrowstatus")
	String BorrowStatus;
	
	@Column(name="incrementdate")
	String IncrementDate;
	
	@Column(name="paiddate")
	String PaidDate;
	
	@Column(name="transfer_code")
	String transfer_code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhoneNumbers getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(PhoneNumbers phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAmount() {
		return AmountBorrowed;
	}

	public void setAmount(String amount) {
		AmountBorrowed = amount;
	}

	public String getRequsetDate() {
		return RequsetDate;
	}

	public void setRequsetDate(String requsetDate) {
		RequsetDate = requsetDate;
	}

	public String getInterest() {
		return Interest;
	}

	public void setInterest(String interest) {
		Interest = interest;
	}
	
	
	public String getAmountToPay() {
		return AmountToPay;
	}

	public void setAmountToPay(String amountToPay) {
		AmountToPay = amountToPay;
	}

	public String getDueDate() {
		return DueDate;
	}

	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}

	public String getBorrowStatus() {
		return BorrowStatus;
	}

	public void setBorrowStatus(String borrowStatus) {
		BorrowStatus = borrowStatus;
	}

	public String getIncrementDate() {
		return IncrementDate;
	}

	public void setIncrementDate(String incrementDate) {
		IncrementDate = incrementDate;
	}

	public String getPaidDate() {
		return PaidDate;
	}

	public void setPaidDate(String paidDate) {
		PaidDate = paidDate;
	}

	public String getTransfer_code() {
		return transfer_code;
	}

	public void setTransfer_code(String transfer_code) {
		this.transfer_code = transfer_code;
	}
	
	
}
