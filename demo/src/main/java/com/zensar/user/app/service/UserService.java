package com.zensar.user.app.service;

import com.zensar.user.app.dto.UserDto;
import com.zensar.user.app.request.UserRequest;

public interface UserService {
	public UserDto save(UserRequest user);
}
