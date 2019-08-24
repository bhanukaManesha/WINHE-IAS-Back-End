package com.winhe.institute.management.studentAttendance;

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
public class StudentAttendanceController {

	@Autowired
	private StudentAttendanceService studentAttendaceService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/student-attendance/{token}")
	public JsonWrapper getAllStudentAttendance(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentAttendaceService.getAllStudentAttendance();
		}

		return data;

	}

	@RequestMapping("/student-attendance/{id}/{token}")
	public JsonWrapper getStudentAttendance(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentAttendaceService.getStudentAttendance(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/student-attendance/{token}")
	public JsonWrapper addStudentAttendance(@RequestBody StudentAttendance studentAttendance, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentAttendaceService.addStudentAttendance(studentAttendance);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/student-attendance/{id}/{token}")
	public JsonWrapper updateStudentAttendance(@RequestBody StudentAttendance studentAttendance, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentAttendaceService.updateStudentAttendance(id, studentAttendance);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/student-attendance/{id}/{token}")
	public JsonWrapper deleteStudentAttendance(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentAttendaceService.deleteStudentAttendance(id);
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
