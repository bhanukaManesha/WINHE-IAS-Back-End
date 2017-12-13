package com.winhe.institute.management.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winhe.institute.management.jsonwrapper.JsonWrapper;
import com.winhe.institute.management.loginuser.LoginUser;



@RestController
public class SessionController {

		@Autowired
		private SessionService sessionService;

		@RequestMapping("/sessions")
		public JsonWrapper getSessions() {
			return sessionService.getAllSessions();
		}

		@RequestMapping("/sessions/{token}")
		public JsonWrapper getSession(@PathVariable String token) {
			return sessionService.getSession(token);
		}

		@RequestMapping(method = RequestMethod.POST, value = "/sessions")
		public JsonWrapper addSession(@RequestBody LoginUser loginUser) {
			return sessionService.addSession(loginUser);
		}


		@RequestMapping(method = RequestMethod.DELETE, value = "/sessions/{token}")
		public JsonWrapper deleteSession(@PathVariable String token) {
			return sessionService.deleteSession(token);
		}

	}

