package com.sawai.medical.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sawai.medical.model.Address;
import com.sawai.medical.model.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	/*public List<Address> getByUser(@Param("user") User user);*/
	
	/*@Transactional
	public void deleteByUser(@Param("user") User user);*/
}
