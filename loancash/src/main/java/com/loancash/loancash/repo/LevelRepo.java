package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.CreditHistory;
import com.loancash.loancash.entity.Level;
import com.loancash.loancash.entity.PhoneNumbers;
import com.loancash.loancash.entity.ServiceOptions;

public interface LevelRepo extends JpaRepository<Level, Integer> {

	///////////////////////////this is method is for the first timers
	@Query("from Level where phonenumber = ?1")
	public Level findByLevel(PhoneNumbers myphonenumber);
		
}
