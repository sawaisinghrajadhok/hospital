package com.sawai.medical.controller;

import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sawai.medical.model.Experience;
import com.sawai.medical.service.ExperienceService;

@RestController
@RequestMapping("/experience")
@Api(value = "experience controller")
public class ExperienceController {

	@Autowired
	private ExperienceService experienceService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Experience create(@RequestBody Experience experience) {
		return experienceService.create(experience);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Experience> getAll() {
		return experienceService.getAll();
	}
	
	@RequestMapping(value = "/provider/{providerId}", method = RequestMethod.GET)
	public List<Experience> getByProvider(@PathVariable("providerId") Long providerId) {
		return experienceService.getByProvider(providerId);
	}
	
	@RequestMapping(value = "/create/multiple/{providerId}", method = RequestMethod.POST)
	public List<Experience> createMultiple(@RequestBody List<Experience> experiences, @PathVariable("providerId") Long providerId) {
		return experienceService.createExperiences(experiences, providerId);
	}
	
	@RequestMapping(value = "/{experienceId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("experienceId") Long experienceId) {
		experienceService.delete(experienceId);
	}
	
	@RequestMapping(value = "/delete/multiple/{providerId}", method = RequestMethod.DELETE)
	public void deleteByProvider(@PathVariable("providerId") Long providerId) {
		experienceService.deleteByProvider(providerId);
	}
}
