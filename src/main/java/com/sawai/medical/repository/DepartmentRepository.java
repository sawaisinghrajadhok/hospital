package com.sawai.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sawai.medical.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
}
