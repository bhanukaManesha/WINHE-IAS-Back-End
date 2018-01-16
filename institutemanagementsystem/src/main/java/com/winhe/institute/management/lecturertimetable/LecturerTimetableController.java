package com.winhe.institute.management.lecturertimetable;

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
public class LecturerTimetableController {

	@Autowired
	private LecturerTimetableService lecturerTimetableService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/lecturer-timetables/{token}")
	public JsonWrapper getAllLecturerTimetables(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerTimetableService.getAllLecturerTimetables();
		}

		return data;

	}

	@RequestMapping("/lecturer-timetables/{id}/{token}")
	public JsonWrapper getLecturerTimetable(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerTimetableService.getLecturerTimetable(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/lecturer-timetables/{token}")
	public JsonWrapper addLecturerTimetable(@RequestBody LecturerTimetable lecturerTimetable, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerTimetableService.addLecturerTimetable(lecturerTimetable);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/lecturer-timetables/{id}/{token}")
	public JsonWrapper updateLecturerTimetable(@RequestBody LecturerTimetable lecturerTimetable, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerTimetableService.updateLecturerTimetable(id, lecturerTimetable);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/lecturer-timetables/{id}/{token}")
	public JsonWrapper deleteLecturerTimetable(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerTimetableService.deleteLecturerTimetable(id);
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
