package com.winhe.institute.management.HttpFilter;

import org.springframework.beans.factory.annotation.Autowired;

import com.winhe.institute.management.jsonwrapper.JsonWrapper;
import com.winhe.institute.management.session.Session;
import com.winhe.institute.management.session.SessionService;


public class HttpFilter {

	@Autowired
	private SessionService sessionService;
	
	public JsonWrapper ValidateLogin(String token) {
		
		
		Session session = (Session) sessionService.getSession(token).getData();
		
		if (session == null) {
			JsonWrapper data = new JsonWrapper("U404", "ERROR , No Users Found");
			return data;
		}
		
		JsonWrapper data = new JsonWrapper("U200", "SUCCESS , User Found",session);
		return data;
		
	}
}
