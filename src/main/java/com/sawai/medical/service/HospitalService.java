package com.sawai.medical.service;

import java.util.List;
import com.sawai.medical.model.Hospital;

public interface HospitalService {
public Hospital create(Hospital hospital);
	
	public List<Hospital> getAll();
	
	public Hospital getById(Long id);
	
	public void delete (Long id);
}
