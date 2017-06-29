package com.sawai.medical.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.sawai.medical.model.User;

public interface UserService extends UserDetailsService {
	public User create(User user);

	public List<User> getAllUsers();

	public User getById(Long id);

	public Boolean userExist(String emailId);

	public Boolean isEnabled(boolean isEnabled, Long id);

	public void delete(Long userId);
}
