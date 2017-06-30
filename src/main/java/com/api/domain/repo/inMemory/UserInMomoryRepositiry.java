package com.api.domain.repo.inMemory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.api.Util;
import com.api.domain.User;
import com.api.domain.repo.UserDAO;

@Repository
public class UserInMomoryRepositiry implements UserDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<User> userDB = null;

	public UserInMomoryRepositiry() {
		userDB = this.init();
	}

	public User createUser(int id, String name, String userName, Date dateOfBirth) {
		return new User(id, name, userName, dateOfBirth);
	}

	public List<User> init() {
		ArrayList<User> users = new ArrayList<>();
		users.add(createUser(1, "Pankaj", "pkj", Util.now()));
		users.add(createUser(2, "rubab", "ru-123", Util.now()));
		users.add(createUser(3, "vibu", "vibu", Util.now()));
		users.add(createUser(4, "Yashita", "yashita", Util.now()));
		return users;
	}

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
		return userDB.stream().filter(user -> Objects.nonNull(userId) && user.getId() == userId)
				.peek(u -> logger.info("\n\n\n" + u.toString() + "\n\n\n")).findAny().orElse(null);
	}

	@Override
	public User findByUserName(String userName) {
		return this.userDB.stream().filter(user -> Objects.nonNull(user.getName()) && user.getName() == userName)
				.findAny().orElse(null);
	}

	@Override
	public List<User> findAllUsers() {
		return userDB;
	}

	@Override
	public void deleteUser(User user) {
		userDB.remove(userDB.get(user.getId()));
	}

	@Override
	public void removeProfileImage(Long userId) {

	}

}
