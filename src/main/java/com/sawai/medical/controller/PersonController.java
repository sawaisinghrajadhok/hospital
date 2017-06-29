package com.sawai.medical.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawai.medical.model.Person;
import com.sawai.medical.service.PersonService;

@RestController
@RequestMapping(value = "/person")
@Api(value = "PersonController")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Person> getAllPersons() {
		return personService.getAllPerson();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getById(@PathVariable("id") Long id) {
		return personService.getById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		personService.delete(id);
	}
}
