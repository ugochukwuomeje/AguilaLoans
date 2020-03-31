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

@Entity
@Table(name="nextamount")
public class NextAmount {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="phonenumber")
	PhoneNumbers phonenumer;
	
	@Column(name="amount")
	String amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhoneNumbers getPhonenumer() {
		return phonenumer;
	}

	public void setPhonenumer(PhoneNumbers phonenumer) {
		this.phonenumer = phonenumer;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
