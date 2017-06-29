package com.sawai.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sawai.medical.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
