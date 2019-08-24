package com.winhe.institute.management.mail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Message {

	@Id
	@SequenceGenerator(name="message_generator", sequenceName="message_seq", allocationSize = 1, initialValue = 700)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="message_generator")
	private Long id;
	
	private String subject;
	private String message;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param subject
	 * @param message
	 * @param createdupdated
	 */
	public Message(Long id, String subject, String message, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.subject = subject;
		this.message = message;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Message() {
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
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
