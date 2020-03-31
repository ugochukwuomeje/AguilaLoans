package com.loancash.loancash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loancash.loancash.entity.ServiceOptions;

public interface ShowAllOptions extends JpaRepository<ServiceOptions, Integer> {

	///////////////////////////this is method is for the first timers
	@Query("from ServiceOptions where id <>2 and id <> 4")
	List<ServiceOptions> findByFirstTimeServiceOptions(boolean status);
	
	///////////////////////////this is method is for the person that is owing
	@Query("from ServiceOptions where id <>1")
	List<ServiceOptions> findByOwingServiceOptions(boolean status);
	
	///////////////////////////this is method is for the first timers
	@Query("from ServiceOptions where id <>2")
	List<ServiceOptions> findByNotOwingServiceOptions(boolean status);
}
