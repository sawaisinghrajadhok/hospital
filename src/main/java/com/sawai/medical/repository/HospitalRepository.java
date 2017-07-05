package com.sawai.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawai.medical.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	
}
