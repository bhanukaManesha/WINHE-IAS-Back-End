package com.winhe.institute.management.associate.lecturer_batch;

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
public class Lecturer_Batch_Controller {

	@Autowired
	private Lecturer_Batch_Service lecturer_Batch_Service;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/lecturer-batch/{token}")
	public JsonWrapper getAllLecturerBatch(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Service.getAllLecturerBatch();
		}
		return data;
	}
	
	@RequestMapping("/lecturer-batch/{id}/{token}")
	public JsonWrapper getLecturerBatch(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Service.getLecturerBatch(id);
		}
		return data;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/lecturer-batch/{token}")
	public JsonWrapper addLecturerBatch(@RequestBody Lecturer_Batch lecturer_Batch, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Service.addLecturerBatch(lecturer_Batch);
		}

		return data;

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/lecturer-batch/{id}/{token}")
	public JsonWrapper updateLecturerBatch(@RequestBody Lecturer_Batch lecturer_Batch, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Service.updateLecturerBatch(id, lecturer_Batch);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/lecturer-batch/{id}/{token}")
	public JsonWrapper deleteLecturerBatch(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return lecturer_Batch_Service.deleteLecturerBatch(id);
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
