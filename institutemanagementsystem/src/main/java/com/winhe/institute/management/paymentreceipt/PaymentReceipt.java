package com.winhe.institute.management.paymentreceipt;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PaymentReceipt {

	@Id
	@SequenceGenerator(name="paymentreceipt_generator", sequenceName="paymentreceipt_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="paymentreceipt_generator")
	private Long id;
	
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateIssued;
	
	
	
	
	
}
