package com.winhe.institute.management.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

		if (data.getCode() == "LOGIN200") {
			return studentService.getAllStudents();
		}

		return data;

	}

	@RequestMapping("/students/{id}/{token}")
	public JsonWrapper getStudent(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentService.getStudent(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/students/{token}")
	public JsonWrapper addStudent(@RequestBody Student student, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentService.addStudent(student);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/students/{id}/{token}")
	public JsonWrapper updateStudent(@RequestBody Student student, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentService.updateStudent(id, student);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/students/{id}/{token}")
	public JsonWrapper deleteStudent(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentService.deleteStudent(id);
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

		JsonWrapper data = new JsonWrapper("LOGIN200", "SUCCESS , User Found", session);

		return data;

	}
}
