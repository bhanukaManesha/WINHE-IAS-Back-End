package com.winhe.institute.management.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.role.Role;

@Entity
public class User {
	
	@Id
	@SequenceGenerator(name="user_generator", sequenceName="user_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_generator")
	private Integer id;
	private String userName;
	private String email;
	private String password;
	@ManyToOne
	private Role role;
	
	public User(Integer id, String userName, String email, String password, Role role) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User() {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	
	
}
