package com.winhe.institute.management.exam_timetable;

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
public class ExamTimetableController {

	@Autowired
	private ExamTimetableService examTimetableService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/exam-timetables/{token}")
	public JsonWrapper getAllExamTimetables(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examTimetableService.getAllExamTimetables();
		}

		return data;

	}

	@RequestMapping("/exam-timetables/{id}/{token}")
	public JsonWrapper getExamTimetable(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examTimetableService.getExamTimetable(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/exam-timetables/{token}")
	public JsonWrapper addExamTimetable(@RequestBody ExamTimetable examTimetable, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examTimetableService.addExamTimetable(examTimetable);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/exam-timetables/{id}/{token}")
	public JsonWrapper updateExamTimetable(@RequestBody ExamTimetable examTimetable, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examTimetableService.updateExamTimetable(id, examTimetable);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/exam-timetables/{id}/{token}")
	public JsonWrapper deleteExamTimetable(@PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return examTimetableService.deleteExamTimetable(id);
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
