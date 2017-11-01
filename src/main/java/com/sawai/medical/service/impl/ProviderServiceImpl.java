package com.sawai.medical.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawai.medical.model.Experience;
import com.sawai.medical.model.Provider;
import com.sawai.medical.repository.ProviderRepository;
import com.sawai.medical.service.ProviderService;
import com.sawai.medical.util.DateSubtractUtil;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderRepository providerRepository;
	
	@Override
	public Provider create(Provider provider) {
		//Float totalExperience = createTotalExperience(provider);
		return providerRepository.save(provider);
	}

	@Override
	public Provider getById(Long id) {
		return providerRepository.findOne(id);
	}

	@Override
	public List<Provider> getAll() {
		return providerRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		providerRepository.delete(id);
	}
	
	private Float createTotalExperience(Provider provider) {
		int year, month, days;
		year = month = days = 0;
		for (Experience experience : provider.getExperiences()) {
			Date doj = experience.getInstitution().getDoj();
			Date dol = experience.getInstitution().getDol();
			int[] result = DateSubtractUtil.subtract(dol, doj);
			year += result[0];
			month += result[1];
			days += result[2];
		}
		return null;
	}

	
	
}
