package com.winhe.institute.management.branchPhoneNo;

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
public class BranchPhoneNoController {

	@Autowired
	private BranchPhoneNoService branchPhoneNoService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/branch-phone-no/{token}")
	public JsonWrapper getAllBranchPhoneNo(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchPhoneNoService.getAllBranchPhoneNo();
		}

		return data;

	}

	@RequestMapping("/branch-phone-no/{id}/{token}")
	public JsonWrapper getBranchPhoneNo(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchPhoneNoService.getBranchPhoneNo(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/branch-phone-no/{token}")
	public JsonWrapper addBranchPhoneNo(@RequestBody BranchPhoneNo branchPhoneNo, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchPhoneNoService.addBranchPhoneNo(branchPhoneNo);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/branch-phone-no/{id}/{token}")
	public JsonWrapper updateBranchPhoneNo(@RequestBody BranchPhoneNo branchPhoneNo, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchPhoneNoService.updateBranchPhoneNo(id, branchPhoneNo);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/branch-phone-no/{id}/{token}")
	public JsonWrapper deleteBranchPhoneNo(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return branchPhoneNoService.deleteBranchPhoneNo(id);
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
