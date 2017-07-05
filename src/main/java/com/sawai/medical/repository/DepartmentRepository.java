package com.sawai.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawai.medical.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
}
