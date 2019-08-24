package com.winhe.institute.management.associate.student_course;

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
public class Student_Course_Controller {

	@Autowired
	private Student_Course_Service student_Course_Service;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/student-course/{token}")
	public JsonWrapper getAllStudentCourse(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Course_Service.getAllStudentCourse();
		}

		return data;

	}

	@RequestMapping("/student-course/{id}/{token}")
	public JsonWrapper getStudentCourse(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Course_Service.getStudentCourse(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/student-course/{token}")
	public JsonWrapper addStudentCourse(@RequestBody Student_Course student_Course, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Course_Service.addStudentCourse(student_Course);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/student-course/{id}/{token}")
	public JsonWrapper updateStudentCourse(@RequestBody Student_Course student_Course, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Course_Service.updateStudentCourse(id, student_Course);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/student-course/{id}/{token}")
	public JsonWrapper deleteStudentCourse(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Course_Service.deleteStudentCourse(id);
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
