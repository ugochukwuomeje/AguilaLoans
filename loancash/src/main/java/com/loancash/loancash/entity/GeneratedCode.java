package com.loancash.loancash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="generatedcode")
public class GeneratedCode {
		
	public GeneratedCode() {
		super();
	}
	
	
	public GeneratedCode(int id, String code, String phonenumner, Long time, String status) {
		super();
		this.id = id;
		this.code = code;
		this.phonenumner = phonenumner;
		this.time = time;
		this.status = status;
	}



	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="code")
	String code;
	
	@Column(name="phonenumber")
	String phonenumner;
	
	@Column(name="time")
	Long time;
	
	@Column(name="status")
	String status;

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

	public String getPhonenumner() {
		return phonenumner;
	}

	public void setPhonenumner(String phonenumner) {
		this.phonenumner = phonenumner;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "GeneratedCode [id=" + id + ", code=" + code + ", phonenumner=" + phonenumner + ", time=" + time
				+ ", status=" + status + "]";
	}
	
	
	
	
}
