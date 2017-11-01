package com.sawai.medical.controller;

import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sawai.medical.model.User;
import com.sawai.medical.service.UserService;

@Api(value = "User Controller")
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable("id") Long id) {
		return userService.getById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/enable/{isEnabled}/{id}", method = RequestMethod.PUT)
	public Boolean isEnabled(@PathVariable("isEnabled") boolean isEnabled, @PathVariable("id") Long id) {
		return userService.isEnabled(isEnabled, id);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("userId") Long userId) {
		userService.delete(userId);
	}
}
