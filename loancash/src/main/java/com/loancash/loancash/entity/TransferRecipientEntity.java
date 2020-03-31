package com.loancash.loancash.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transferreceipient")
public class TransferRecipientEntity {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	int id;
	
	@Column(name="code")	
	String code;
	
	@OneToOne(mappedBy="transferreceipient", cascade=CascadeType.ALL)
	Bankacc bankacc;
		
	public TransferRecipientEntity() {
		super();
	}

	public TransferRecipientEntity(int id, String code, Bankacc bankacc) {
		super();
		this.id = id;
		this.code = code;
		this.bankacc = bankacc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Bankacc getBankacc() {
		return bankacc;
	}

	public void setBankacc(Bankacc bankacc) {
		this.bankacc = bankacc;
	}
	
	
}
