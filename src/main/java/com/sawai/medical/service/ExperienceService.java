package com.sawai.medical.service;

import java.util.List;

import com.sawai.medical.model.Experience;

public interface ExperienceService {
	
	public Experience create(Experience experience);
	
	public List<Experience> createExperiences(List<Experience> experiences, Long provider);
	
	public List<Experience> getAll();
	
	public List<Experience> getByProvider(Long providerId);
	
	public void delete(Long id);

	public void deleteByProvider(Long providerId);

	
}
