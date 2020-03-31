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
@Table(name="level")
public class Level {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="phonenumber")
	PhoneNumbers phonenumber;
	
	@Column(name="level")
	int level;

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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
