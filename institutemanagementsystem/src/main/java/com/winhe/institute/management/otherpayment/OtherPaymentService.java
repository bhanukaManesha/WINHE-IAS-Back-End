package com.winhe.institute.management.otherpayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class OtherPaymentService {

	@Autowired
	private OtherPaymentRepository otherPaymentRepository;
	
	public JsonWrapper getAllOtherPayments(){
		
		JsonWrapper data = new JsonWrapper("OTHERPAYMENTS200", "List of All the Other Payments", otherPaymentRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getOtherPayment(String id){
		
		OtherPayment otherPayment = otherPaymentRepository.findOne(Long.valueOf(id));

		if (otherPayment == null) {
			JsonWrapper data = new JsonWrapper("OTHERPAYMENTS404", "ERROR , No Other Payments Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("OTHERPAYMENTS200", "Other Payments Found", otherPayment);

		return data;
		
		
	};
	
	public JsonWrapper addOtherPayment(OtherPayment otherPayment) {

		otherPaymentRepository.save(otherPayment);

		JsonWrapper data = new JsonWrapper("OTHERPAYMENTS200", "Other Payments Successfully Added", otherPayment);

		return data;
	};
	
	public JsonWrapper updateOtherPayment(Long id, OtherPayment otherPayment) {

		OtherPayment tempOtherPayment = otherPaymentRepository.findOne(id);

		if (tempOtherPayment == null) {
			JsonWrapper data = new JsonWrapper("OTHERPAYMENTS404", "ERROR , No Other Payments Found");
			return data;
		}

		otherPayment.setId(id);
		otherPaymentRepository.save(otherPayment);
		
		JsonWrapper data = new JsonWrapper("OTHERPAYMENTS200", "Other Payments Successfully Updated", otherPayment);

		return data;
	};
	
	public JsonWrapper deleteOtherPayment(Long id) {

		OtherPayment tempOtherPayment = otherPaymentRepository.findOne(id);

		if (tempOtherPayment == null) {
			JsonWrapper data = new JsonWrapper("OTHERPAYMENTS404", "ERROR , No Other Payments Found");
			return data;
		}

		otherPaymentRepository.delete(id);

		JsonWrapper data = new JsonWrapper("OTHERPAYMENTS200", "SUCCESFULLY DELETED");

		return data;
	};
}
