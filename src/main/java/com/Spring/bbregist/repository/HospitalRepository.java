package com.Spring.bbregist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.bbregist.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
	Hospital findByEmail(String email);

}
