package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.Bankacc;
import com.loancash.loancash.entity.Banks;
import com.loancash.loancash.entity.CreditHistory;
import com.loancash.loancash.entity.Level;
import com.loancash.loancash.entity.PhoneNumbers;
import com.loancash.loancash.entity.ServiceOptions;
import com.loancash.loancash.entity.Settings;

public interface BanksRepo extends JpaRepository<Banks, Integer> {

	///////////////////////////this is method is for the first timers
	@Query("from Banks where bankcode = ?1")
	public Banks findBybankcode(String bankcode);
}
