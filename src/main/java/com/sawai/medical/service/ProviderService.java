package com.sawai.medical.service;

import java.util.List;
import com.sawai.medical.model.Provider;

public interface ProviderService {
	
	public Provider create(Provider provider);
	
	public Provider getById(Long id);
	
	public List<Provider> getAll();
	
	public void delete(Long id);
}
