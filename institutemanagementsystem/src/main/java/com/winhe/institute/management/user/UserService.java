package com.winhe.institute.management.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public JsonWrapper getAllUsers() {

		List<User> users = new ArrayList<>();

		userRepository.findAll().forEach(users::add);

		if (users.isEmpty()) {
			JsonWrapper data = new JsonWrapper("U404", "ERROR , No Users Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("U200", "SUCCESS", users);

		return data;
	};

	public JsonWrapper getUser(Integer id) {

		User user = userRepository.findOne(id);

		if (user == null) {
			JsonWrapper data = new JsonWrapper("U404", "ERROR , No User Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("U200", "SUCCESS", user);

		return data;

	};
	

	public JsonWrapper getUserByEmail(String email) {

		User user = userRepository.findByEmail(email);

		if (user == null) {
			JsonWrapper data = new JsonWrapper("U404", "ERROR , No User Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("U200", "SUCCESS", user);

		return data;

	};

	public JsonWrapper addUser(User user) {

		userRepository.save(user);

		JsonWrapper data = new JsonWrapper("U200", "SUCCESFULLY ADDED", user);

		return data;
	};

	public JsonWrapper updateUser(Integer id, User user) {

		User tempUser = userRepository.findOne(id);

		if (tempUser == null) {
			JsonWrapper data = new JsonWrapper("U404", "ERROR , No User Found");
			return data;
		}

		user.setId(id);
		userRepository.save(user);
		JsonWrapper data = new JsonWrapper("U200", "SUCCESFULLY UPDATED", user);

		return data;
	};

	public JsonWrapper deleteUser(Integer id) {

		User tempUser = userRepository.findOne(id);

		if (tempUser == null) {
			JsonWrapper data = new JsonWrapper("U404", "ERROR , No User Found");
			return data;
		}

		userRepository.delete(id);

		JsonWrapper data = new JsonWrapper("U200", "SUCCESFULLY DELETED");

		return data;
	};

}
