package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.CreditHistory;
import com.loancash.loancash.entity.PhoneNumbers;
import com.loancash.loancash.entity.ServiceOptions;

public interface CreditHistoryRepo extends JpaRepository<CreditHistory, Integer> {

	///////////////////////////this is method is for the first timers
	@Query("from CreditHistory where phonenumber = ?1 and BorrowStatus =?2")
	CreditHistory findByBorrowStatus(String Phonenumber, String borrowstatus);
	
	///////////////////////////this is method is for the first timers
	@Query("from CreditHistory where phonenumber = ?1")
	CreditHistory findByPhoneNumber(PhoneNumbers Phonenumber);
	
	///////////////////////////this method is for web hook when loan is completely transfered
	@Query("from CreditHistory where transfer_code = ?1 and BorrowStatus =?2")
	CreditHistory findBytranfercodeandstatus(String transfer_code, String status);
			
}
