package com.winhe.institute.management.branch;

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
public class BranchController {

	@Autowired
	private BranchService branchService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/branch/{token}")
	public JsonWrapper getAllBranches(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {

			return branchService.getAllBranches();
		}
		return data;
	}

	@RequestMapping("/branch/{id}/{token}")
	public JsonWrapper getBranch(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchService.getBranch(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/branch/{token}")
	public JsonWrapper addBranch(@RequestBody Branch branch, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchService.addBranch(branch);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/branch/{id}/{token}")
	public JsonWrapper updateBranch(@RequestBody Branch branch, @PathVariable Long id,
			@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchService.updateBranch(id, branch);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/branch/{id}/{token}")
	public JsonWrapper deleteBranch(@PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchService.deleteBranch(id);
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

