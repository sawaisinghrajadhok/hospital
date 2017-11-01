package com.sawai.medical.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawai.medical.model.Experience;
import com.sawai.medical.model.Provider;
import com.sawai.medical.repository.ExperienceRepository;
import com.sawai.medical.service.ExperienceService;
import com.sawai.medical.service.ProviderService;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Autowired
	private ProviderService providerService;
	
	@Override
	public Experience create(Experience experience) {
		return experienceRepository.save(experience);
	}

	@Override
	public List<Experience> createExperiences(List<Experience> experiences, Long providerId) {
		List<Experience> output = new ArrayList<Experience>();
		Provider provider = providerService.getById(providerId);
		for (Experience experience : experiences) {
			experience.setProvider(provider);
			output.add(create(experience));
		}
		return output;
	}

	@Override
	public List<Experience> getAll() {
		return experienceRepository.findAll();
	}

	@Override
	public List<Experience> getByProvider(Long providerId) {
		Provider provider = providerService.getById(providerId);
		return experienceRepository.getByProvider(provider);
	}

	@Override
	public void delete(Long experienceId) {
		experienceRepository.delete(experienceId);
	}
	
	@Override
	public void deleteByProvider(Long providerId) {
		Provider provider = providerService.getById(providerId);
		experienceRepository.deleteByProvider(provider);
	}
}
