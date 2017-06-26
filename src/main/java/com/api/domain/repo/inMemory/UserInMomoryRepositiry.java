package com.api.domain.repo.inMemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.api.domain.User;
import com.api.domain.repo.UserDAO;

@Repository
public class UserInMomoryRepositiry implements UserDAO {

	private List<User> userDB = new ArrayList<>();

	private int getNextSequenceValue() {
		return this.userDB.stream().mapToInt(user -> user.getId()).max().orElse(0) + 1;

	}

	@Override
	public void createUser(User user) {
		user.setId(getNextSequenceValue());
		userDB.add(user);
	}

	@Override
	public User findById(int userId) {
		return userDB.stream().filter(user -> Objects.nonNull(userId) && user.getId() == userId).findAny().orElse(null);
	}

	@Override
	public User findByUserName(String userName) {
		return this.userDB.stream().filter(user -> Objects.nonNull(user.getName()) && user.getName() == userName)
				.findAny().orElse(null);
	}

}
