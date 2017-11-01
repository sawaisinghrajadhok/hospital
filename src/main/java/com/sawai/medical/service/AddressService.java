package com.sawai.medical.service;

import java.util.List;
import com.sawai.medical.model.Address;

public interface AddressService {
	public Address create(Address address);

	public List<Address> getAllAddresses();

	public List<Address> getByUser(Long userId);
	
	public Address getById(Long id);

	public void delete(Long id);
	
	public List<Address> createAddresses(List<Address> addresses, Long userId);
	
	public void deleteAllUser(Long id);
	
}
