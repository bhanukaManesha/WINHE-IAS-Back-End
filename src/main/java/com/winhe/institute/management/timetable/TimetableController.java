package com.winhe.institute.management.timetable;

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
public class TimetableController {

	@Autowired
	private TimetableService timetableService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/timetable/{token}")
	public JsonWrapper getAllTimetables(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return timetableService.getAllTimetables();
		}

		return data;

	}

	@RequestMapping("/timetable/{id}/{token}")
	public JsonWrapper getTimetable(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return timetableService.getTimetable(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/timetable/{token}")
	public JsonWrapper addTimetable(@RequestBody Timetable timetable, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return timetableService.addTimetable(timetable);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/timetable/{id}/{token}")
	public JsonWrapper updateTimetable(@RequestBody Timetable timetable, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return timetableService.updateTimetable(id, timetable);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/timetable/{id}/{token}")
	public JsonWrapper deleteTimetable(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return timetableService.deleteTimetable(id);
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
