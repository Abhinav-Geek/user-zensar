package com.zensar.user.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.user.app.advice.UserInfoDuplicateException;
import com.zensar.user.app.dto.UserDto;
import com.zensar.user.app.entity.UserEntity;
import com.zensar.user.app.repository.UserRepository;
import com.zensar.user.app.request.UserRequest;
import com.zensar.user.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDto save(UserRequest userRequest) throws UserInfoDuplicateException {
		UserEntity userToSave = new UserEntity();
		setUserEntity(userRequest, userToSave);
		UserEntity savedUser =  null;
		try {
			savedUser =  repository.save(userToSave);
		} catch(Exception e) {
			throw new UserInfoDuplicateException(e.getMessage());
		}
		return setUserDto(savedUser);
	}

	private UserDto setUserDto(UserEntity savedUser) {
		UserDto userDto = new UserDto();
		userDto.setUserName(savedUser.getUserName());
		userDto.setMobile(savedUser.getMobile());
		userDto.setPin(savedUser.getPin());
		userDto.setEmail(savedUser.getEmail());
		userDto.setId(savedUser.getId());
		return userDto;
	}

	private UserEntity setUserEntity(UserRequest userRequest, UserEntity userToSave) {
		userToSave.setUserName(userRequest.getUserName());
		userToSave.setMobile(userRequest.getMobile());
		userToSave.setPin(userRequest.getPin());
		userToSave.setEmail(userRequest.getEmail());
		return userToSave;
	}

}
