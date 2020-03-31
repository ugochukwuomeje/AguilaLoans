package com.loancash.loancash.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="phonenumbers")
public class PhoneNumbers {

		
	public PhoneNumbers() {
	
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="phonenumber")
	@NotEmpty(message="Please enter the category name")
	private String phonenumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="phonenumber")
	public List<CreditHistory> ceredithistory;
			
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<CreditHistory> getCeredithistory() {
		return ceredithistory;
	}

	public void setCeredithistory(List<CreditHistory> ceredithistory) {
		this.ceredithistory = ceredithistory;
	}

	@Override
	public String toString() {
		return "PhoneNumbers [id=" + id + ", phonenumber=" + phonenumber + "]";
	}
	
	
}
