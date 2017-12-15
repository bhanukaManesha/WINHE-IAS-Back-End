package com.winhe.institute.management.mail;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.user.User;

public class InternalMail {

	@Id
	@SequenceGenerator(name="internalmail_generator", sequenceName="internalmail_seq", allocationSize = 1, initialValue = 4000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="internalmail_generator")
	private Long id;
	
	@ManyToOne
	private User sender;
	
	@ManyToOne
	private User reciever;
}
