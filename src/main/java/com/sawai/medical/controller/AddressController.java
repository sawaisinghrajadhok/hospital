package com.sawai.medical.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawai.medical.model.Address;
import com.sawai.medical.service.AddressService;

@RestController
@RequestMapping("/address")
@Api(value = "Address Controller")

public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value = "/create/multiple/{userId}", method = RequestMethod.POST)
	public List<Address> createAddresses(@RequestBody List<Address> addresses, @PathVariable("userId") Long userId) {
		return addressService.createAddresses(addresses, userId);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Address create(@RequestBody Address address) {
		return addressService.create(address);
	}
		
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Address> getAllAddresses() {
		return addressService.getAllAddresses();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Address getById(@PathVariable("id") Long id) {
		return addressService.getById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		addressService.delete(id);
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public List<Address> getByUser(@PathVariable("userId") Long userId) {
		return addressService.getByUser(userId);
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	public void deleteAllUser(@PathVariable("userId") Long userId) {
		addressService.deleteAllUser(userId);
	}
}
