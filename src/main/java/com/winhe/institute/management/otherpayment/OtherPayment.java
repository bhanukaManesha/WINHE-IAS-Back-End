package com.winhe.institute.management.otherpayment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.winhe.institute.management.paymentreceipt.PaymentReceipt;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

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
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param paymentType
	 * @param date
	 * @param nameOfPayee
	 * @param description
	 * @param amount
	 * @param paymentReceipt
	 * @param createdupdated
	 */
	public OtherPayment(Long id, String paymentType, Date date, String nameOfPayee, String description, Double amount,
			PaymentReceipt paymentReceipt, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.paymentType = paymentType;
		this.date = date;
		this.nameOfPayee = nameOfPayee;
		this.description = description;
		this.amount = amount;
		this.paymentReceipt = paymentReceipt;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public OtherPayment() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the nameOfPayee
	 */
	public String getNameOfPayee() {
		return nameOfPayee;
	}

	/**
	 * @param nameOfPayee the nameOfPayee to set
	 */
	public void setNameOfPayee(String nameOfPayee) {
		this.nameOfPayee = nameOfPayee;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the paymentReceipt
	 */
	public PaymentReceipt getPaymentReceipt() {
		return paymentReceipt;
	}

	/**
	 * @param paymentReceipt the paymentReceipt to set
	 */
	public void setPaymentReceipt(PaymentReceipt paymentReceipt) {
		this.paymentReceipt = paymentReceipt;
	}

	/**
	 * @return the createdupdated
	 */
	public CreatedUpdated getCreatedupdated() {
		return createdupdated;
	}

	/**
	 * @param createdupdated the createdupdated to set
	 */
	public void setCreatedupdated(CreatedUpdated createdupdated) {
		this.createdupdated = createdupdated;
	}
	
	

}
