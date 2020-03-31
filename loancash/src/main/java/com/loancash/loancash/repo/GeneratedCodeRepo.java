package com.loancash.loancash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.GeneratedCode;
import com.loancash.loancash.entity.PhoneNumbers;

public interface GeneratedCodeRepo extends JpaRepository<GeneratedCode, Integer> {

	
	////this checks the whether code matches that was sent matches the phonenumber
	@Query("from GeneratedCode where phonenumber=?1 and code=?2 ")
	GeneratedCode findByCodeAndNumber(String phonenumber, String code, Long time);
	
	/*
	////this changes the status from pending to expired
	@Modifying
	@Query("UPDATE GeneratedCode SET status = ?1 WHERE phonenumber=?2 and code=?3 ")
	void updatedBystatus(String status, String phonenumber, String code, Long time);*/
	
	//////this changes the status from pending from used
	@Query("UPDATE GeneratedCode SET status =?1 WHERE phonenumber=?2 and code=?3")
	GeneratedCode updateByPhonenumber(String status, String phonenumber, String code);
}
