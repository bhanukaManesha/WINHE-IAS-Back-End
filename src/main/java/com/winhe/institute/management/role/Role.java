package com.winhe.institute.management.role;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winhe.institute.management.user.User;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Role {
	
	@Id
	private Integer id;
	private String role;
	private String homePath;
	
	@OneToMany(mappedBy="role")
	@JsonBackReference
	private List<User> users;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param role
	 * @param homePath
	 * @param users
	 * @param createdupdated
	 */
	public Role(Integer id, String role, String homePath, List<User> users, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.role = role;
		this.homePath = homePath;
		this.users = users;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the homePath
	 */
	public String getHomePath() {
		return homePath;
	}

	/**
	 * @param homePath the homePath to set
	 */
	public void setHomePath(String homePath) {
		this.homePath = homePath;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
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
