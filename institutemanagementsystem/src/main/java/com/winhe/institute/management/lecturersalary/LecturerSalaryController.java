package com.winhe.institute.management.lecturersalary;

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
public class LecturerSalaryController {

	@Autowired
	private LecturerSalaryService lecturerSalaryService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/lecturer-salary/{token}")
	public JsonWrapper getAllLecturerSalaries(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerSalaryService.getAllLecturerSalaries();
		}

		return data;

	}

	@RequestMapping("/lecturer-salary/{id}/{token}")
	public JsonWrapper getLecturerSalary(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerSalaryService.getLecturerSalary(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/lecturer-salary/{token}")
	public JsonWrapper addLecturerSalary(@RequestBody LecturerSalary lecturerSalary, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerSalaryService.addLecturerSalary(lecturerSalary);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/lecturer-salary/{id}/{token}")
	public JsonWrapper updateLecturerSalary(@RequestBody LecturerSalary lecturerSalary, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerSalaryService.updateLecturerSalary(id, lecturerSalary);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/lecturer-salary/{id}/{token}")
	public JsonWrapper deleteLecturerSalary(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerSalaryService.deleteLecturerSalary(id);
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
