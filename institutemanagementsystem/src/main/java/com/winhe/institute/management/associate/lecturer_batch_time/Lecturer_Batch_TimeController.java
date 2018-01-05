package com.winhe.institute.management.associate.lecturer_batch_time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winhe.institute.management.session.Session;
import com.winhe.institute.management.session.SessionService;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@RestController
public class Lecturer_Batch_TimeController {

	@Autowired
	private Lecturer_Batch_TimeService lecturer_batch_timeService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/lecturer_batch_time/{token}")
	public JsonWrapper getAllLecturer_Batch_Time(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {

			return lecturer_batch_timeService.getAllLecturer_Batch_Time();
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
