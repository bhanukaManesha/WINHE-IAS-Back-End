package com.winhe.institute.management.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winhe.institute.management.session.Session;
import com.winhe.institute.management.session.SessionService;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping("/students/{token}")
	public JsonWrapper getAllStudents(@PathVariable String token) {
		
		
		JsonWrapper data = Validation(token);

		if (data.getCode()=="LOGIN200") {
			return studentService.getAllStudents();
		}
		
		return data;
		
	}
	
	
	// Validation Function
	
	private JsonWrapper Validation(String token) {
		
		Session session = (Session) sessionService.getSession(token).getData();
		
		if (session == null) {
			JsonWrapper data = new JsonWrapper("LOGIN404", "ERROR , No Users Found");
			return data;
		}
		
		JsonWrapper data = new JsonWrapper("LOGIN200", "SUCCESS , User Found",session);
		
		return data;
		
	}
}
