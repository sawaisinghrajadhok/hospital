package com.sawai.medical.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sawai.medical.model.Person;
import com.sawai.medical.model.Qualification;
import com.sawai.medical.repository.QualificationRepository;
import com.sawai.medical.service.PersonService;
import com.sawai.medical.service.QualificationService;

@Service
public class QualificationServerImpl implements QualificationService {

	@Autowired
	private QualificationRepository qualificationRepository;
	
	@Autowired
	private PersonService personService;
	
	@Override
	public Qualification create(Qualification qualification) {
		System.out.println(qualification.getPerson());
		System.out.println(qualification.getPerson().getId());
		Person person = personService.getById(qualification.getPerson().getId());
		qualification.setPerson(person);
		return qualificationRepository.save(qualification);
	}

	@Override
	public List<Qualification> createQualifications(List<Qualification> qualifications, Long personId) {
		Person person = personService.getById(personId);
		List<Qualification> output = new ArrayList<Qualification>();
		for(Qualification qualification : qualifications) {
			qualification.setPerson(person);
			output.add(qualificationRepository.save(qualification));
		}
		return output;
	}

	@Override
	public Qualification getById(Long id) {
		return qualificationRepository.findOne(id);
	}

	@Override
	public List<Qualification> getByPerson(Long id) {
		Person person = personService.getById(id);
		return qualificationRepository.getByPerson(person);
	}

	@Override
	public void delete(Long id) {
		System.out.println("delete called with id " + id);
		qualificationRepository.delete(id);
	}

	@Override
	public List<Qualification> getAll() {
		return qualificationRepository.findAll();
	}
}
