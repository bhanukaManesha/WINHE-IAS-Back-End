package com.winhe.institute.management.role;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winhe.institute.management.user.User;

@Entity
public class Role {
	
	@Id
	private Integer id;
	private String role;
	private String homePath;
	
	@OneToMany(mappedBy="role")
	@JsonBackReference
	private List<User> users;
	
	
	

	public Role(Integer id, String role, String homePath, List<User> users) {
		super();
		this.id = id;
		this.role = role;
		this.homePath = homePath;
		this.users = users;
	}


	public Role() {
		
	}

	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getHomePath() {
		return homePath;
	}


	public void setHomePath(String homePath) {
		this.homePath = homePath;
	}
	
	

}
