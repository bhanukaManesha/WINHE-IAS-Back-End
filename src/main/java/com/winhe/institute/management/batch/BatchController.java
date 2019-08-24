package com.winhe.institute.management.batch;

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
public class BatchController {

	@Autowired
	private BatchService batchService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/batches/{token}")
	public JsonWrapper getAllBatches(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batchService.getAllBatches();
		}

		return data;

	}

	@RequestMapping("/batches/{id}/{token}")
	public JsonWrapper getBatch(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batchService.getBatch(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/batches/{token}")
	public JsonWrapper addBatch(@RequestBody Batch batch, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batchService.addBatch(batch);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/batches/{id}/{token}")
	public JsonWrapper updateBatch(@RequestBody Batch batch, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batchService.updateBatch(id, batch);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/batches/{id}/{token}")
	public JsonWrapper deleteBatch(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return batchService.deleteBatch(id);
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
