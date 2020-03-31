package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.PhoneNumbers;



public interface NumberRepo extends JpaRepository<PhoneNumbers, Integer> {

	////////////////////this section is for selecting numbers that received code but not logged in
	@Query("from PhoneNumbers where status=?1")
	List<PhoneNumbers> findByPhoneNumbers(boolean status);
	
	////this checks whether the phone numbers has been there
	@Query("from PhoneNumbers where phonenumber=?1 and code=?2")
	PhoneNumbers findByPhoneNumber(String phonenumber, String code);
	
}
