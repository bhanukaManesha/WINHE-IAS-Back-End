package com.winhe.institute.management.associate.student_batch;

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
public class Student_Batch_Controller {

	@Autowired
	private Student_Batch_Service student_Batch_Service;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/student-batch/{token}")
	public JsonWrapper getAllStudentBatches(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Batch_Service.getAllStudentBatches();
		}

		return data;

	}

	@RequestMapping("/student-batch/{id}/{token}")
	public JsonWrapper getStudentBatch(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Batch_Service.getStudentBatch(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/student-batch/{token}")
	public JsonWrapper addStudentBatch(@RequestBody Student_Batch student_Batch, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Batch_Service.addStudentBatch(student_Batch);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/student-batch/{id}/{token}")
	public JsonWrapper updateStudentBatch(@RequestBody Student_Batch student_Batch, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Batch_Service.updateStudentBatch(id, student_Batch);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/student-batch/{id}/{token}")
	public JsonWrapper deleteStudentBatch(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return student_Batch_Service.deleteStudentBatch(id);
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
