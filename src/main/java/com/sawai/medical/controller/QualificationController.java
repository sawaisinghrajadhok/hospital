package com.sawai.medical.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawai.medical.model.Qualification;
import com.sawai.medical.service.QualificationService;

@RestController
@RequestMapping(value = "/qualification")
@Api(value = "Qualification Controller")
public class QualificationController {
	
	@Autowired
	private QualificationService qualificationService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Qualification> getAllQualification() {
		return qualificationService.getAll();
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Qualification create(@RequestBody Qualification qualification) {
		return qualificationService.create(qualification);
	}

	@RequestMapping(value = "/create/multiple/{personId}", method = RequestMethod.POST)
	public List<Qualification> createQualifications(@RequestBody List<Qualification> qualifications, @PathVariable Long personId) {
		return qualificationService.createQualifications(qualifications, personId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Qualification getById(@PathVariable("id") Long id) {
		return qualificationService.getById(id);
	}

	@RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
	public List<Qualification> getByPerson(@PathVariable("personId") Long id) {
		return qualificationService.getByPerson(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		qualificationService.delete(id);
	}
}
