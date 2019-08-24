package com.winhe.institute.management.associate.batch_branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winhe.institute.management.associate.student_course.Student_Course;
import com.winhe.institute.management.associate.student_course.Student_Course_Service;
import com.winhe.institute.management.session.Session;
import com.winhe.institute.management.session.SessionService;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@RestController
public class Batch_Branch_Controller {

	@Autowired
	private Batch_Branch_Service batch_Branch_Service;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/batch-branch/{token}")
	public JsonWrapper getAllBatchBranch(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batch_Branch_Service.getAllBatchBranch();
		}

		return data;
	}

	@RequestMapping("/batch-branch/{id}/{token}")
	public JsonWrapper getBatchBranch(@PathVariable String id, @PathVariable String token) {
		JsonWrapper data = Validation(token);
		if (data.getCode() == "LOGIN200") {
			return batch_Branch_Service.getBatchBranch(id);

		}
		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/batch-branch/{token}")
	public JsonWrapper addBatchBranch(@RequestBody Batch_Branch batch_Branch, @PathVariable String token) {
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batch_Branch_Service.addBatchBranch(batch_Branch);

		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/batch-branch/{id}/{token}")
	public JsonWrapper updateBatchBranch(@RequestBody Batch_Branch batch_Branch, @PathVariable Long id,
			@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batch_Branch_Service.updateBatchBranch(id, batch_Branch);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/batch-branch/{id}/{token}")
	public JsonWrapper deleteBatchBranch(@PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batch_Branch_Service.deleteBatchBranch(id);
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
