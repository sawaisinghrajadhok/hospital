package com.sawai.medical.controller;

import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sawai.medical.model.Provider;
import com.sawai.medical.service.ProviderService;

@RestController
@RequestMapping(value = "/providers")
@Api(value = "Providers Controller")
public class ProvidersController {
	
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Provider create(@RequestBody Provider providers) {
		return providerService.create(providers);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Provider> getAll() {
		return providerService.getAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Provider getById(@PathVariable("id") Long id) {
		return providerService.getById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		providerService.delete(id);
	}
}
