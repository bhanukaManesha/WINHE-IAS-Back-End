package com.winhe.institute.management.associate.lecturer_batch_time;

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
public class Lecturer_Batch_Time_Controller {

	@Autowired
	private Lecturer_Batch_Time_Service lecturer_Batch_Time_Service;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/lecturer_batch_time/{token}")
	public JsonWrapper getAllLecturerBatchTime(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {

			return lecturer_Batch_Time_Service.getAllLecturerBatchTime();
		}
		return data;
	}

	@RequestMapping("/lecturer-batch-time/{id}/{token}")
	public JsonWrapper getLecturerBatchTime(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Time_Service.getLecturerBatchTime(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/lecturer-batch-time/{token}")
	public JsonWrapper addLecturerBatchTime(@RequestBody Lecturer_Batch_Time lecturer_Batch_Time, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Time_Service.addLecturerBatchTime(lecturer_Batch_Time);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/lecturer-batch-time/{id}/{token}")
	public JsonWrapper updateLecturerBatchTime(@RequestBody Lecturer_Batch_Time lecturer_Batch_Time, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Time_Service.updateLecturerBatchTime(id, lecturer_Batch_Time);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/lecturer-batch-time/{id}/{token}")
	public JsonWrapper deleteLecturerBatchTime(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Time_Service.deleteLecturerBatchTime(id);
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
