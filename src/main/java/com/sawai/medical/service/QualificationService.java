package com.sawai.medical.service;

import java.util.List;

import com.sawai.medical.model.Qualification;

public interface QualificationService {
	
	public List<Qualification> getAll();
	
	public Qualification create(Qualification qualification);

	public Qualification getById(Long id);

	public void delete(Long id);

	public List<Qualification> getByPerson(Long id);

	public List<Qualification> createQualifications(List<Qualification> qualifications, Long personId);

}
