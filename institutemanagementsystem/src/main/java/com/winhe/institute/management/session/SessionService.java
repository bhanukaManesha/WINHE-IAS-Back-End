package com.winhe.institute.management.session;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.user.User;
import com.winhe.institute.management.user.UserService;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;
import com.winhe.institute.management.util.loginuser.LoginUser;

@Service
@Transactional
public class SessionService {

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private UserService userService;

	public JsonWrapper getAllSessions() {

		List<Session> session = new ArrayList<>();

		sessionRepository.findAll().forEach(session::add);

		if (session.isEmpty()) {
			JsonWrapper data = new JsonWrapper("S404", "ERROR , No Sessions Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("S200", "SUCCESS", session);

		return data;
	};

	public JsonWrapper getSession(String token) {

		
		Session session = sessionRepository.findByToken(token);
		
		if (session == null) {
			JsonWrapper data = new JsonWrapper("S404", "ERROR , No Session Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("S200", "SUCCESS", session);

		return data;

	};

	public JsonWrapper addSession(LoginUser loginUser) {

		// Checking whether the user is correct
		JsonWrapper jsonData = userService.getUserByEmail(loginUser.getEmail());

		if (jsonData.getCode() == "S404") {
			JsonWrapper data = new JsonWrapper("S404", "ERROR , Please enter the correct Email");
			return data;
		}

		User user = (User) jsonData.getData();

		if (!loginUser.getPassword().equals(user.getPassword())) {

			JsonWrapper data = new JsonWrapper("S404", "ERROR , Please enter the correct Password");
			return data;

		}

		String token = UUID.randomUUID().toString();

		Session session = new Session(token, user);

		sessionRepository.save(session);

		JsonWrapper data = new JsonWrapper("S200", "SUCCESFULLY LOGGED IN", session);

		return data;
	};

	public JsonWrapper deleteSession(String token) {

		Session tempUser = sessionRepository.findByToken(token);

		if (tempUser == null) {
			JsonWrapper data = new JsonWrapper("S404", "ERROR , No Session Found");
			return data;
		}

		sessionRepository.delete(tempUser.getId());

		JsonWrapper data = new JsonWrapper("S200", "SUCCESFULLY DELETED");

		return data;
	};

}
