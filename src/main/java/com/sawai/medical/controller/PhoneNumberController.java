package com.sawai.medical.controller;

import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sawai.medical.model.PhoneNumber;
import com.sawai.medical.service.PhoneNumberService;

@RestController
@RequestMapping("/phonenumber")
@Api(value = "Phone Number Controller")
public class PhoneNumberController {

	@Autowired
	private PhoneNumberService phoneNumberService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public PhoneNumber createPhoneNumber(@RequestBody PhoneNumber phoneNumber) {
		return phoneNumberService.createPhoneNumber(phoneNumber);
	}
	
	@RequestMapping(value = "create/multiple/{userId}", method = RequestMethod.POST)
	public List<PhoneNumber> createPhoneNumbers(@RequestBody List<PhoneNumber> phoneNumbers, @PathVariable("userId") Long userId) {
		return phoneNumberService.createPhoneNumbers(phoneNumbers, userId);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<PhoneNumber> getAllPhoneNumbers() {
		return phoneNumberService.getAllPhoneNumbers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PhoneNumber getById(@PathVariable("id") Long id) {
		return phoneNumberService.getById(id);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET) 
	public List<PhoneNumber> getByUser(@PathVariable("userId") Long userId) {
		return phoneNumberService.getByUser(userId);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public void delete(@PathVariable("id") Long id) {
		phoneNumberService.delete(id);
	}
	
	@RequestMapping(value="/user/{userId}", method = RequestMethod.DELETE)
	public void deleteByUser(@PathVariable("userId") Long userId) {
		phoneNumberService.deleteByUser(userId);
	}
}
