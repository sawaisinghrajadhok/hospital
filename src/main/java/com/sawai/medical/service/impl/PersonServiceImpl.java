package com.sawai.medical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sawai.medical.model.Person;
import com.sawai.medical.repository.PersonRepository;
import com.sawai.medical.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person create(Person person) {
		return personRepository.save(person);
	}

	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public Person getById(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		personRepository.delete(id);
	}
}
