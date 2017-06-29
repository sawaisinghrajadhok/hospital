package com.sawai.medical.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawai.medical.model.PhoneNumber;
import com.sawai.medical.model.User;
import com.sawai.medical.repository.PhoneNumberRepository;
import com.sawai.medical.service.PhoneNumberService;
import com.sawai.medical.service.UserService;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

	@Autowired
	private PhoneNumberRepository phoneNumberRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public PhoneNumber createPhoneNumber(PhoneNumber phoneNumber) {
		User user = userService.getById(phoneNumber.getUser().getId());
		phoneNumber.setUser(user);
		return phoneNumberRepository.save(phoneNumber);
	}
	
	@Override
	public List<PhoneNumber> createPhoneNumbers(List<PhoneNumber> phoneNumbers, Long userId) {
		User user = userService.getById(userId);
		if (user != null) { 
			List<PhoneNumber> outputList = new ArrayList<PhoneNumber>();
			for (PhoneNumber phoneNumber : phoneNumbers) {
				phoneNumber.setUser(user);
				outputList.add(createPhoneNumber(phoneNumber));
			}
			return outputList;
		}
		throw new EntityNotFoundException("User with id { " + userId + " } not exist");
	}
	
	@Override
	public List<PhoneNumber> getAllPhoneNumbers() {
		return phoneNumberRepository.findAll();
	}

	@Override
	public PhoneNumber getById(Long id) {
		return phoneNumberRepository.findOne(id);
	}

	@Override
	public List<PhoneNumber> getByUser(Long userId) {
		User user = userService.getById(userId);
		return phoneNumberRepository.getByUser(user);
	}
	
	@Override
	public void delete(Long id) {
		phoneNumberRepository.delete(id);
	}

	@Override
	public void deleteByUser(Long userId) {
		List<PhoneNumber> phoneNumbers = getByUser(userId);
		for (PhoneNumber phoneNumber : phoneNumbers) {
			delete(phoneNumber.getId());
		}
	}
}
