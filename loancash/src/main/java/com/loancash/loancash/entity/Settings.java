package com.loancash.loancash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="settings")
public class Settings {

	
	public  Settings() {
		
	}
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="first_amount")
	String firstloan_amount;
	
	@Column(name="percentage_increment")
	String percentage_increment;
	
	@Column(name="percentage_change")
	String percentage_change;
	
	@Column(name="first_pay_date")
	int first_pay_date;
	
	@Column(name="second_pay_date")
	int second_pay_date;
	
	@Column(name="secondinterest")
	int secondinterest;
	
	@Column(name="firstinterest")
	int firstinterest;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstloan_amount() {
		return firstloan_amount;
	}
	public void setFirstloan_amount(String firstloan_amount) {
		this.firstloan_amount = firstloan_amount;
	}
	public String getPercentage_increment() {
		return percentage_increment;
	}
	public void setPercentage_increment(String percentage_increment) {
		this.percentage_increment = percentage_increment;
	}
	
	public String getPercentage_change() {
		return percentage_change;
	}
	
	public void setPercentage_change(String percentage_change) {
		this.percentage_change = percentage_change;
	}
	
	public int getFirst_pay_date() {
		return first_pay_date;
	}
	
	public void setFirst_pay_date(int first_pay_date) {
		this.first_pay_date = first_pay_date;
	}
	
	public int getSecond_pay_date() {
		return second_pay_date;
	}
	
	public void setSecond_pay_date(int second_pay_date) {
		this.second_pay_date = second_pay_date;
	}
	public int getSecondinterest() {
		return secondinterest;
	}
	public void setSecondinterest(int secondinterest) {
		this.secondinterest = secondinterest;
	}
	public int getFirstinterest() {
		return firstinterest;
	}
	public void setFirstinterest(int firstinterest) {
		this.firstinterest = firstinterest;
	}
	
	
}
