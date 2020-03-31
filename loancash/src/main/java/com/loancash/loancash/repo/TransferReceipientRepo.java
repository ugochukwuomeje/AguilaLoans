package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.CreditHistory;
import com.loancash.loancash.entity.PhoneNumbers;
import com.loancash.loancash.entity.ServiceOptions;
import com.loancash.loancash.entity.TransferRecipientEntity;
import com.loancash.loancash.model.TransferReceipientCode;

public interface TransferReceipientRepo extends JpaRepository<TransferRecipientEntity, Integer> {

	
		
}
