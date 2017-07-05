package com.sawai.medical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sawai.medical.model.Department;
import com.sawai.medical.repository.DepartmentRepository;
import com.sawai.medical.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department create(Department department) {
		return null;
	}

	@Override
	public Department getById(Long id) {
		return null;
	}

	@Override
	public List<Department> getAll() {
		return null;
	}

	@Override
	public List<Department> getByHospital(Long hospitalId) {
		return null;
	}

	@Override
	public void delete(Long id) {
		
	}
}
