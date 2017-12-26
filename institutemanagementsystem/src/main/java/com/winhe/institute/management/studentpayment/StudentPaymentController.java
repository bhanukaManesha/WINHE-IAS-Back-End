package com.winhe.institute.management.studentpayment;

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
public class StudentPaymentController {

	@Autowired
	private StudentPaymentService studentPaymentService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/student-payment/{token}")
	public JsonWrapper getAllStudentPayments(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentPaymentService.getAllStudentPayments();
		}

		return data;

	}

	@RequestMapping("/student-payment/{id}/{token}")
	public JsonWrapper getStudentPayment(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentPaymentService.getStudentPayment(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/student-payment/{token}")
	public JsonWrapper addStudentPayment(@RequestBody StudentPayment studentPayment, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentPaymentService.addStudentPayment(studentPayment);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/student-payment/{id}/{token}")
	public JsonWrapper updateStudentPayment(@RequestBody StudentPayment studentPayment, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentPaymentService.updateStudentPayment(id, studentPayment);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/student-payment/{id}/{token}")
	public JsonWrapper deleteStudentPayment(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return studentPaymentService.deleteStudentPayment(id);
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
