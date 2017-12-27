package com.winhe.institute.management.upload;

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
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/upload/{token}")
	public JsonWrapper getAllUploads(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return uploadService.getAllUploads();
		}

		return data;

	}

	@RequestMapping("/upload/{id}/{token}")
	public JsonWrapper getUpload(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return uploadService.getUpload(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/upload/{token}")
	public JsonWrapper addUpload(@RequestBody Upload upload, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return uploadService.addUpload(upload);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/upload/{id}/{token}")
	public JsonWrapper updateUpload(@RequestBody Upload upload, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return uploadService.updateUpload(id, upload);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/upload/{id}/{token}")
	public JsonWrapper deleteUpload(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return uploadService.deleteUpload(id);
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
