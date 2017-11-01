package com.sawai.medical.service;

import java.util.List;

import com.sawai.medical.model.Department;

public interface DepartmentService {
	public Department create(Department department);

	public Department getById(Long id);

	public List<Department> getAll();

	public List<Department> getByHospital(Long hospitalId);

	public void delete(Long id);
}
