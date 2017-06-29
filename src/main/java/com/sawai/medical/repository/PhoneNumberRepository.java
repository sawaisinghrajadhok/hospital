package com.sawai.medical.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sawai.medical.model.PhoneNumber;
import com.sawai.medical.model.User;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long>{
	public List<PhoneNumber> getByUser(@Param("user") User user);
	
}
