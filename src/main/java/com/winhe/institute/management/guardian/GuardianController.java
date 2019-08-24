package com.winhe.institute.management.guardian;

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
public class GuardianController {

	@Autowired
	private GuardianService guardianService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/guardian/{token}")
	public JsonWrapper getAllGuardians(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return guardianService.getAllGuardians();
		}

		return data;

	}

	@RequestMapping("/guardian/{id}/{token}")
	public JsonWrapper getGuardian(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return guardianService.getGuardian(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/guardian/{token}")
	public JsonWrapper addGuardian(@RequestBody Guardian guardian, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return guardianService.addGuardian(guardian);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/guardian/{id}/{token}")
	public JsonWrapper updateGuardian(@RequestBody Guardian guardian, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return guardianService.updateGuardian(id, guardian);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/guardian/{id}/{token}")
	public JsonWrapper deleteGuardian(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return guardianService.deleteGuardian(id);
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
