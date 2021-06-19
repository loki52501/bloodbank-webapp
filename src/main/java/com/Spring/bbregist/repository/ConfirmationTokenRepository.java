package com.Spring.bbregist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Spring.bbregist.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
	
	@Query("select t from ConfirmationToken t where t.confirmationt=:confirmationToken")
    ConfirmationToken findByConfirmationt(@Param("confirmationToken")String confirmationToken);
    
    
}