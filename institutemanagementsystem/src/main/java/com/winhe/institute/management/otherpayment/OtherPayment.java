package com.winhe.institute.management.otherpayment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.winhe.institute.management.paymentreceipt.PaymentReceipt;

@Entity
public class OtherPayment {
	
	@Id
	private Long id;
	
	private String paymentType;
	private Date date;
	private String nameOfPayee;
	private String description;
	private Double amount;
	
	@OneToOne
	private PaymentReceipt paymentReceipt;

}
