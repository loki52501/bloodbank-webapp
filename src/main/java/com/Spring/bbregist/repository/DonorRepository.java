package com.Spring.bbregist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.bbregist.model.Donor;
@Repository
public interface DonorRepository extends JpaRepository<Donor,Integer>{
	
	Donor findByEmail(String email);
	
	 
	List<Donor> findAll() ;

	 
	Donor deleteByEmail(String email);
	
	@Query("SELECT d FROM Donor d WHERE d.city=:city")
	List<Donor> findByCity(@Param("city") String city);

	@Query("SELECT d FROM Donor d WHERE d.email=:email")
	Optional<Donor> findByemail(String email);

	@Query("SELECT d FROM Donor d  WHERE lower(CONCAT(d.firstname, ' ', d.bloodgroup, ' ', d.city, ' ', d.phno)) LIKE lower(concat( '%',:keyword,'%'))")
	List<Donor> search(@Param("keyword")String keyword);

	@Modifying
	@Transactional 
	@Query(value="UPDATE blood_bank_registry.donor\r\n"
			+ "	SET  invite= 1\r\n"
			+ "	WHERE email=:email",nativeQuery = true)
    void UpdateInvite(@Param("email")String email);
	
	@Modifying
	@Transactional 
	@Query(value="UPDATE blood_bank_registry.donor\r\n"
			+ "	SET  invite= invite +1\r\n"
			+ "	WHERE email=:email",nativeQuery = true)
	void UpdateInviteany(@Param("email") String email);
}
