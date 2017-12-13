package com.winhe.institute.management.session;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.winhe.institute.management.user.User;

@Entity
public class Session {

	@Id
	@SequenceGenerator(name="session_generator", sequenceName="session_seq", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="session_generator")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long id;
	
	private String token;
	
	@ManyToOne
	private User user;

	public Session(Long id, String token, User user) {
		super();
		this.id = id;
		this.token = token;
		this.user = user;
	}
	
	public Session(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}
	
	public Session(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}
	

	public Session() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
