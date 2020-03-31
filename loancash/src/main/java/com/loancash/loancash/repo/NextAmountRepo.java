package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.CreditHistory;
import com.loancash.loancash.entity.NextAmount;
import com.loancash.loancash.entity.ServiceOptions;

public interface NextAmountRepo extends JpaRepository<NextAmount, Integer> {

	///////////////////////////this is method is for the first timers
	@Query("from NextAmount where phonenumber = ?1")
	NextAmount findByPhoneNumber(String Phonenumber);
	
}
