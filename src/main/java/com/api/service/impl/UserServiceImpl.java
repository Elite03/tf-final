package com.api.service.impl;

import java.util.List;

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

	public User createNewUser(String name, String userName, String password) {
		User user = new User();
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);

		userRepositiry.createUser(user);
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepositiry.findAllUsers();
	}

	@Override
	public User createNewUser(User user) {
		userRepositiry.createUser(user);
		return user;
	}

	@Override
	public void updateUser(User user) {
		User existingUser = userRepositiry.findById(user.getId());
		existingUser.setName(user.getName());
		existingUser.setUserName(user.getUserName());
		existingUser.setDateOfBirth(user.getDateOfBirth());
		userRepositiry.createUser(existingUser);
	}

	@Override
	public void deleteUser(User user) {
		userRepositiry.deleteUser(user);
	}

	@Override
	public void deleteProfileImage(Long userId) {
		// TODO Auto-generated method stub

	}

}
