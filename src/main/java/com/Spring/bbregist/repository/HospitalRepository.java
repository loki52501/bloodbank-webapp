package com.Spring.bbregist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Spring.bbregist.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
	Hospital findByEmail(String email);
	
	@Query("SELECT h FROM Hospital h WHERE h.email=:email")
	Optional<Hospital> findByemail(String email);

}
