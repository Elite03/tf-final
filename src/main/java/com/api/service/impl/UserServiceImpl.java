package com.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.domain.User;
import com.api.domain.repo.UserDAO;
import com.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userRepositiry;

	@Override
	public User findById(int userId) {
		return userRepositiry.findById(userId);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepositiry.findByUserName(userName);
	}

	@Override
	public User createNewUser(String name, String userName, String password) {
		User user = new User();
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);

		userRepositiry.createUser(user);
		return user;
	}

}
