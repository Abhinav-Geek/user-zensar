package com.zensar.user.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.user.app.dto.UserDto;
import com.zensar.user.app.request.UserRequest;
import com.zensar.user.app.service.UserService;


/**
 * @author Abhinav Pareek
 * User Controller is for handling user module requests
 *
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/")
	public UserDto addUser(@Valid @RequestBody UserRequest user) {
		return userService.save(user);
	}

}
