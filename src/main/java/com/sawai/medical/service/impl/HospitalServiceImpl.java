package com.sawai.medical.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.sawai.medical.model.Hospital;
import com.sawai.medical.repository.HospitalRepository;
import com.sawai.medical.service.HospitalService;

public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Override
	public Hospital create(Hospital hospital) {
		return null;
	}

	@Override
	public List<Hospital> getAll() {
		return null;
	}

	@Override
	public Hospital getById(Long id) {
		return null;
	}

	@Override
	public void delete(Long id) {
		 
	}

}
