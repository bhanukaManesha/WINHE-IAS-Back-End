package com.winhe.institute.management.paymentreceipt;

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
public class PaymentReceiptController {


	@Autowired
	private PaymentReceiptService paymentReceiptService;

	@Autowired
	private SessionService sessionService;

	@RequestMapping("/payment-receipt/{token}")
	public JsonWrapper getAllPaymentReciepts(@PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return paymentReceiptService.getAllPaymentReciepts();
		}

		return data;

	}

	@RequestMapping("/payment-receipt/{id}/{token}")
	public JsonWrapper getPaymentReceipt(@PathVariable String id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return paymentReceiptService.getPaymentReceipt(id);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/payment-receipt/{token}")
	public JsonWrapper addPaymentReceipt(@RequestBody PaymentReceipt paymentReceipt, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return paymentReceiptService.addPaymentReceipt(paymentReceipt);
		}

		return data;

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/payment-receipt/{id}/{token}")
	public JsonWrapper updatePaymentReceipt(@RequestBody PaymentReceipt paymentReceipt, @PathVariable Long id, @PathVariable String token) {

		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return paymentReceiptService.updatePaymentReceipt(id, paymentReceipt);
		}

		return data;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/payment-receipt/{id}/{token}")
	public JsonWrapper deletePaymentReceipt(@PathVariable Long id,  @PathVariable String token) {
		
		JsonWrapper data = Validation(token);

		if (data.getCode() == "LOGIN200") {
			return paymentReceiptService.deletePaymentReceipt(id);
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
