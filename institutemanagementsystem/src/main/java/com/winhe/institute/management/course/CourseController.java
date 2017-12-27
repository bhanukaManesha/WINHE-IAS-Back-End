package com.winhe.institute.management.course;

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
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/courses/{token}")
	public JsonWrapper getAllCourses(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return courseService.getAllCourses();
		}

		return data;

	}

	@RequestMapping("/courses/{id}/{token}")
	public JsonWrapper getCourse(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return courseService.getCourse(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/courses/{token}")
	public JsonWrapper addCourse(@RequestBody Course course, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return courseService.addCourse(course);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}/{token}")
	public JsonWrapper updateCourse(@RequestBody Course course, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return courseService.updateCourse(id, course);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}/{token}")
	public JsonWrapper deleteCourse(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return courseService.deleteCourse(id);
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
