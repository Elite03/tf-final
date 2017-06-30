package com.api.domain.repo;

import java.util.List;

import com.api.domain.User;

public interface UserDAO {

	void createUser(User user);

	User findById(int userId);

	User findByUserName(String userName);

	void deleteUser(User user);

	List<User> findAllUsers();

	// File addProfileImage(Long userId, String fileName);

	void removeProfileImage(Long userId);
}
