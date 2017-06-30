package com.api.service;

import java.util.List;

import com.api.domain.User;

public interface UserService {
	User findById(int userId);

	User findByUserName(String userName);

	User createNewUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	List<User> findAllUsers();

	// File addProfileImage(Long userId, String fileName);

	void deleteProfileImage(Long userId);
}
