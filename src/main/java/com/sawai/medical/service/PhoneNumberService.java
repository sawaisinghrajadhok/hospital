package com.sawai.medical.service;

import java.util.List;
import com.sawai.medical.model.PhoneNumber; 

public interface PhoneNumberService {
	public PhoneNumber createPhoneNumber(PhoneNumber phoneNumber);

	public List<PhoneNumber> createPhoneNumbers(List<PhoneNumber> phoneNumbers, Long userId);

	public List<PhoneNumber> getAllPhoneNumbers();

	public PhoneNumber getById(Long id);

	public void delete(Long id);

	public List<PhoneNumber> getByUser(Long userId);

	public void deleteByUser(Long userId);
}
