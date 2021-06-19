package com.Spring.bbregist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.bbregist.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
	
	
	Hospital findByEmail(String email);
	
	@Query("SELECT h FROM Hospital h WHERE h.email=:email")
	Optional<Hospital> findByemail(String email);

@Modifying
@Transactional 
@Query(value="UPDATE spl.hospital\r\n"
		+ "	SET enabled=true\r\n"
		+ "	WHERE email=:email",nativeQuery = true)
void UpdateEnable(@Param("email")String email);
}
