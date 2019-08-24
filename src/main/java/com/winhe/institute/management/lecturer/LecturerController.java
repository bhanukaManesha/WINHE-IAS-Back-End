package com.winhe.institute.management.lecturer;

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
public class LecturerController {

	@Autowired
	private LecturerService lecturerService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/lecturer/{token}")
	public JsonWrapper getAllLecturers(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {

			return lecturerService.getAllLecturers();
		}
		return data;
	}

	@RequestMapping("/lecturer/{id}/{token}")
	public JsonWrapper getLecturer(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerService.getLecturer(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/lecturer/{token}")
	public JsonWrapper addLecturer(@RequestBody Lecturer lecturer, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerService.addLecturer(lecturer);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/lecturer/{id}/{token}")
	public JsonWrapper updateLecturer(@RequestBody Lecturer lecturer, @PathVariable Long id,
			@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerService.updateLecturer(id, lecturer);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/lecturer/{id}/{token}")
	public JsonWrapper deleteLecturer(@PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerService.deleteLecturer(id);
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
