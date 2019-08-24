package com.winhe.institute.management.mail;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.user.User;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class InternalMail {

	@Id
	@SequenceGenerator(name="internalmail_generator", sequenceName="internalmail_seq", allocationSize = 1, initialValue = 4000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="internalmail_generator")
	private Long id;
	
	@ManyToOne
	private User sender;
	
	@ManyToOne
	private User reciever;
	
	@OneToOne
	private Message message;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param sender
	 * @param reciever
	 * @param createdupdated
	 */
	public InternalMail(Long id, User sender, User reciever, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.sender = sender;
		this.reciever = reciever;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public InternalMail() {
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
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 * @return the reciever
	 */
	public User getReciever() {
		return reciever;
	}

	/**
	 * @param reciever the reciever to set
	 */
	public void setReciever(User reciever) {
		this.reciever = reciever;
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
