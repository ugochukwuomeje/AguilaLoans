package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.Bankacc;
import com.loancash.loancash.entity.CreditHistory;
import com.loancash.loancash.entity.Level;
import com.loancash.loancash.entity.PhoneNumbers;
import com.loancash.loancash.entity.ServiceOptions;
import com.loancash.loancash.entity.Settings;

public interface SelectAccRepo extends JpaRepository<Bankacc, Integer> {

	///////////////////////////this is method is for the first timers
	@Query("from Bankacc where phone =?1")
	List<Bankacc> findByPhoneNumber(String phonenumber);
}
