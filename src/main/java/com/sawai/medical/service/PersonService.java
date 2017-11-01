package com.sawai.medical.service;

import java.util.List;

import com.sawai.medical.model.Person;

public interface PersonService {
	public Person create(Person person);
	
	public List<Person> getAllPerson();
	
	public Person getById(Long id);
	
	public void delete(Long id);
}
