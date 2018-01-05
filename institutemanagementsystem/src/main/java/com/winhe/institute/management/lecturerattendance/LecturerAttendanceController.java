package com.winhe.institute.management.lecturerattendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winhe.institute.management.associate.student_batch.Student_Batch;
import com.winhe.institute.management.session.Session;
import com.winhe.institute.management.session.SessionService;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@RestController
public class LecturerAttendanceController {

	@Autowired
	private LecturerAttendanceService lecturerAttendanceService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/lecturer-attendance/{token}")
	public JsonWrapper getAllLecturerAttendance(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {

			return lecturerAttendanceService.getAllLecturerAttendance();
		}
		return data;

	}

	@RequestMapping("/lecturer-attendance/{id}/{token}")
	public JsonWrapper getLecturerAttendance(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerAttendanceService.getLecturerAttendance(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/lecturer-attendance/{token}")
	public JsonWrapper addlecturerAttendance(@RequestBody LecturerAttendance lecturerAttendance,
			@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerAttendanceService.addLecturerAttendance(lecturerAttendance);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/lecturer-attendance/{id}/{token}")
	public JsonWrapper updateLecturerAttendance(@RequestBody LecturerAttendance lecturerAttendance,
			@PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerAttendanceService.updateLecturerAttendance(id, lecturerAttendance);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/lecturer-attendance/{id}/{token}")
	public JsonWrapper deleteLecturerAttendance(@PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturerAttendanceService.deleteLecturerAttendance(id);
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
