package com.sawai.medical.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawai.medical.model.Address;
import com.sawai.medical.model.User;
import com.sawai.medical.repository.AddressRepository; 
import com.sawai.medical.service.AddressService;
import com.sawai.medical.service.UserService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Address create(Address address) {
		/*User user = userService.getById(address.getUser().getId());
		address.setUser(user);
		return addressRepository.save(address);*/
		return null;
	}

	@Override
	public List<Address> createAddresses(List<Address> addresses, Long UserId) {
		List<Address> output = new ArrayList<Address>();
		User user = new User();
		user.setId(UserId);
		for (Address address : addresses) {
			//address.setUser(user);
			output.add(create(address));
		}
		return output;
	}
	
	@Override
	public List<Address> getAllAddresses() {
		return addressRepository.findAll();
	}

	@Override
	public Address getById(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		addressRepository.delete(id);
	}

	@Override
	public List<Address> getByUser(Long userId) {
		User user = userService.getById(userId);
		//return addressRepository.getByUser(user);
		return null;
	}

	@Override
	public void deleteAllUser(Long id) {
		User user = userService.getById(id);
		//addressRepository.deleteByUser(user);
	}
}
