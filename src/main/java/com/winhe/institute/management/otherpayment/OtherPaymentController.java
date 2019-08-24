package com.winhe.institute.management.otherpayment;

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
public class OtherPaymentController {


	@Autowired
	private OtherPaymentService otherPaymentService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/other-payment/{token}")
	public JsonWrapper getAllOtherPayments(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return otherPaymentService.getAllOtherPayments();
		}

		return data;

	}

	@RequestMapping("/other-payment/{id}/{token}")
	public JsonWrapper getOtherPayment(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return otherPaymentService.getOtherPayment(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/other-payment/{token}")
	public JsonWrapper addOtherPayment(@RequestBody OtherPayment otherPayment, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return otherPaymentService.addOtherPayment(otherPayment);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/other-payment/{id}/{token}")
	public JsonWrapper updateOtherPayment(@RequestBody OtherPayment otherPayment, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return otherPaymentService.updateOtherPayment(id, otherPayment);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/other-payment/{id}/{token}")
	public JsonWrapper deleteOtherPayment(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return otherPaymentService.deleteOtherPayment(id);
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
