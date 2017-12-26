package com.winhe.institute.management.studentpayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class StudentPaymentService {

	@Autowired
	private StudentPaymentRepository studentPaymentRepository;
	
	public JsonWrapper getAllStudentPayments(){
		
		JsonWrapper data = new JsonWrapper("STUDENTPAYMENT200", "List of All the Student Payments", studentPaymentRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getStudentPayment(String id){
		
		StudentPayment studentPayment = studentPaymentRepository.findOne(Long.valueOf(id));

		if (studentPayment == null) {
			JsonWrapper data = new JsonWrapper("STUDENTPAYMENT404", "ERROR , No Student Payments Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("STUDENTPAYMENT200", "Student Payment Found", studentPayment);

		return data;
		
		
	};
	
	public JsonWrapper addStudentPayment(StudentPayment studentPayment) {

		studentPaymentRepository.save(studentPayment);

		JsonWrapper data = new JsonWrapper("STUDENTPAYMENT200", "Student Payment Successfully Added", studentPayment);

		return data;
	};
	
	public JsonWrapper updateStudentPayment(Long id, StudentPayment studentPayment) {

		StudentPayment tempStudentPayment = studentPaymentRepository.findOne(id);

		if (tempStudentPayment == null) {
			JsonWrapper data = new JsonWrapper("STUDENTPAYMENT404", "ERROR , No Student Payment Found");
			return data;
		}

		studentPayment.setId(id);
		studentPaymentRepository.save(studentPayment);
		
		JsonWrapper data = new JsonWrapper("STUDENTPAYMENT200", "Student Payment Successfully Updated", studentPayment);

		return data;
	};
	
	public JsonWrapper deleteStudentPayment(Long id) {

		StudentPayment tempStudentPayment = studentPaymentRepository.findOne(id);

		if (tempStudentPayment == null) {
			JsonWrapper data = new JsonWrapper("STUDENTPAYMENT404", "ERROR , No Student Payment Found");
			return data;
		}

		studentPaymentRepository.delete(id);

		JsonWrapper data = new JsonWrapper("STUDENTPAYMENT200", "SUCCESFULLY DELETED");

		return data;
	};
}
