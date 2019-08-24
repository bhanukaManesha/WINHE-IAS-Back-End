package com.winhe.institute.management.paymentreceipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class PaymentReceiptService {

	@Autowired
	private PaymentReceiptRepository paymentReceiptRepository;
	
	public JsonWrapper getAllPaymentReciepts(){
		
		JsonWrapper data = new JsonWrapper("PAYMENTRECEIPT200", "List of All the Payment Receipts", paymentReceiptRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getPaymentReceipt(String id){
		
		PaymentReceipt paymentReceipt = paymentReceiptRepository.findOne(Long.valueOf(id));

		if (paymentReceipt == null) {
			JsonWrapper data = new JsonWrapper("PAYMENTRECEIPT404", "ERROR , No Payment Receipts Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("PAYMENTRECEIPT200", "Payment Receipts Found", paymentReceipt);

		return data;
		
		
	};
	
	public JsonWrapper addPaymentReceipt(PaymentReceipt paymentReceipt) {

		paymentReceiptRepository.save(paymentReceipt);

		JsonWrapper data = new JsonWrapper("PAYMENTRECEIPT200", "Payment Receipts Successfully Added", paymentReceipt);

		return data;
	};
	
	public JsonWrapper updatePaymentReceipt(Long id, PaymentReceipt paymentReceipt) {

		PaymentReceipt tempPaymentReceipt = paymentReceiptRepository.findOne(id);

		if (tempPaymentReceipt == null) {
			JsonWrapper data = new JsonWrapper("PAYMENTRECEIPT404", "ERROR , No Payment Receipts Found");
			return data;
		}

		paymentReceipt.setId(id);
		paymentReceiptRepository.save(paymentReceipt);
		
		JsonWrapper data = new JsonWrapper("PAYMENTRECEIPT200", "Payment Receipts Successfully Updated", paymentReceipt);

		return data;
	};
	
	public JsonWrapper deletePaymentReceipt(Long id) {

		PaymentReceipt tempPaymentReceipt = paymentReceiptRepository.findOne(id);

		if (tempPaymentReceipt == null) {
			JsonWrapper data = new JsonWrapper("PAYMENTRECEIPT404", "ERROR , No Payment Receipts Found");
			return data;
		}

		paymentReceiptRepository.delete(id);

		JsonWrapper data = new JsonWrapper("PAYMENTRECEIPT200", "SUCCESFULLY DELETED");

		return data;
	};
}
