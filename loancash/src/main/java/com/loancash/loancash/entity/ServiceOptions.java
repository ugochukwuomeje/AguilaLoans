package com.loancash.loancash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="options")
public class ServiceOptions {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="option")
	String singleoption;
	
	@Column(name="status")
	boolean status;

	public ServiceOptions(int id, String option, boolean status) {
		
		this.id = id;
		singleoption = option;
		this.status = status;
	}

	public ServiceOptions() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		
	public String getSingleoption() {
		return singleoption;
	}

	public void setSingleoption(String singleoption) {
		this.singleoption = singleoption;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
