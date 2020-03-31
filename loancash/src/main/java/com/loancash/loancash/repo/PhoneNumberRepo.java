package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.CreditHistory;
import com.loancash.loancash.entity.Level;
import com.loancash.loancash.entity.PhoneNumbers;
import com.loancash.loancash.entity.ServiceOptions;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumbers, Integer> {

	///////////////////////////this method gets the phone number object
	@Query("from PhoneNumbers where phonenumber = ?1")
	public PhoneNumbers findByPhoneNumber(String phonenumber);
	
	
		
}
