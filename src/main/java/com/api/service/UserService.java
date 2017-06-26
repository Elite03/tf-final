package com.api.service;

import com.api.domain.User;

public interface UserService {

	User findById(int userId);

	User findByUserName(String userName);

	User createNewUser(String name, String userName, String password);
}
