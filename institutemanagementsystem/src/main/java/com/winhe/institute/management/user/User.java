package com.winhe.institute.management.user;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.winhe.institute.management.mail.InternalMail;
import com.winhe.institute.management.role.Role;
import com.winhe.institute.management.session.Session;




@Entity
public class User {
	
	@Id
	@SequenceGenerator(name="user_generator", sequenceName="user_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_generator")
	private Integer id;
	private String userName;
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Session> session;

	@OneToMany(mappedBy="sender")
	private List<InternalMail> internalMailSend;
	
	@OneToMany(mappedBy="reciever")
	private List<InternalMail> internalMailReciever;

	
	
}
