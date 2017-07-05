package com.sawai.medical.controller;

import java.util.List;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawai.medical.model.Hospital;
import com.sawai.medical.service.HospitalService;

@RestController
@RequestMapping(value = "/hospital")
@Api(value = "HOSPITAL")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Hospital create(@RequestBody Hospital hospital) {
		return hospitalService.create(hospital);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Hospital> getAll() {
		return hospitalService.getAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Hospital getById(@PathVariable("id") Long id) {
		return hospitalService.getById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		hospitalService.delete(id);
	}
	
}
