package com.sawai.medical.controller;

import java.util.List;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawai.medical.model.Department;
import com.sawai.medical.service.DepartmentService;

@RestController
@RequestMapping(value = "/department")
@Api(value = "DEPARTMENT")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "", method = RequestMethod.POST) 
	public Department create(@RequestBody Department department) {
		return departmentService.create(department);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Department getById(@PathVariable("id") Long id) {
		return departmentService.getById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Department> getAll() {
		return departmentService.getAll();
	}
	
	@RequestMapping(value = "/hospital/{hospitalId}", method = RequestMethod.GET)
	public List<Department> getByHospital(@PathVariable("hospitalId") Long hospitalId) {
		return departmentService.getByHospital(hospitalId);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE) 
	public void delete(@PathVariable("id") Long id) {
		departmentService.delete(id);
	}
}
