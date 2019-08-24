package com.winhe.institute.management.inquiry;

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
public class InquiryController {

	@Autowired
	private InquiryService inquiryService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/inquiry/{token}")
	public JsonWrapper getAllInquiries(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return inquiryService.getAllInquiries();
		}

		return data;

	}

	@RequestMapping("/inquiry/{id}/{token}")
	public JsonWrapper getInquiry(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return inquiryService.getInquiry(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/inquiry/{token}")
	public JsonWrapper addInquiry(@RequestBody Inquiry inquiry, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return inquiryService.addInquiry(inquiry);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/inquiry/{id}/{token}")
	public JsonWrapper updateInquiry(@RequestBody Inquiry inquiry, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return inquiryService.updateInquiry(id, inquiry);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/inquiry/{id}/{token}")
	public JsonWrapper deleteInquiry(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return inquiryService.deleteInquiry(id);
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
