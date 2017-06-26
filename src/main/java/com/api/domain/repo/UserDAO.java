package com.api.domain.repo;

import com.api.domain.User;

public interface UserDAO {

	void createUser(User user);

	User findById(int userId);

	User findByUserName(String userName);
}
