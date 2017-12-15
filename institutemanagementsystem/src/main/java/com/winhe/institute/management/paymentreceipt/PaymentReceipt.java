package com.winhe.institute.management.paymentreceipt;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class PaymentReceipt {

	@Id
	@SequenceGenerator(name="paymentreceipt_generator", sequenceName="paymentreceipt_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="paymentreceipt_generator")
	private Long id;
	
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateIssued;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param name
	 * @param dateIssued
	 * @param createdupdated
	 */
	public PaymentReceipt(Long id, String name, Date dateIssued, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.name = name;
		this.dateIssued = dateIssued;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public PaymentReceipt() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateIssued
	 */
	public Date getDateIssued() {
		return dateIssued;
	}

	/**
	 * @param dateIssued the dateIssued to set
	 */
	public void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
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
