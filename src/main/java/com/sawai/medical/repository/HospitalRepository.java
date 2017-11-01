package com.sawai.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sawai.medical.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	
}
