package com.loancash.loancash.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="bankacc")
public class Bankacc {
		
	public Bankacc() {
		
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@NotNull(message="Please enter account account numer")
	@NotEmpty(message="Please enter account account number")
	@Column(name="accno")
	String accno;
	
	@NotNull(message="Please enter account accountname")
	@NotEmpty(message="Please enter account accountname")
	@Column(name="accname")
	String accname;
	
	@Column(name="bank")
	String bank;
	
	@Column(name="phone")
	String phone;

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="transferreceipient")
	TransferRecipientEntity transferreceipient;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public TransferRecipientEntity getTransferreceipient() {
		return transferreceipient;
	}

	public void setTransferreceipient(TransferRecipientEntity transferreceipient) {
		this.transferreceipient = transferreceipient;
	}

	@Override
	public String toString() {
		return "bankacc [id=" + id + ", accno=" + accno + ", accname=" + accname + ", bank=" + bank + "]";
	}
	
	
	
}
