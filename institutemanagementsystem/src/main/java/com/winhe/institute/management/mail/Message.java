package com.winhe.institute.management.mail;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Message {

	@Id
	@SequenceGenerator(name="message_generator", sequenceName="message_seq", allocationSize = 1, initialValue = 700)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="message_generator")
	private Long id;
	
	private String subject;
	private String message;
	
	
}
