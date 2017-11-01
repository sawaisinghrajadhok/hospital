package com.sawai.medical.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sawai.medical.enums.Role;
import com.sawai.medical.model.User;
import com.sawai.medical.repository.UserRepository;
import com.sawai.medical.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		User user = userRepository.getByEmailId(emailId);
		if (user != null) {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			for(Role role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.toValue()));
			}
			user.setAuthorities(authorities);
		}
		return user;
	}
	
	@Override
	public User create(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public Boolean userExist(String emailId) {
		if (loadUserByUsername(emailId) != null)
			return true;
		return false;
	}

	@Override
	public Boolean isEnabled(boolean isEnabled, Long id) {
		User user = userRepository.getOne(id);
		if (user != null) {
			if (user.isEnabled() != isEnabled) {
				System.out.println("inside if block !!!");
				System.out.println(isEnabled);
				user.setEnabled(isEnabled);;
				userRepository.save(user);
				return true;
			}
		}
		return false;
	}

	@Override
	public void delete(Long userId) {
		userRepository.delete(userId);
	}
}
