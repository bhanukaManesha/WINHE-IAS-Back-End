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
import com.winhe.institute.management.branchPhoneNo.BranchPhoneNo;
import com.winhe.institute.management.mail.InternalMail;
import com.winhe.institute.management.role.Role;
import com.winhe.institute.management.session.Session;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

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

	@ManyToOne
	private BranchPhoneNo branchPhoneNo;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param userName
	 * @param email
	 * @param password
	 * @param role
	 * @param session
	 * @param internalMailSend
	 * @param internalMailReciever
	 * @param branchPhoneNo
	 * @param createdupdated
	 */
	public User(Integer id, String userName, String email, String password, Role role, List<Session> session,
			List<InternalMail> internalMailSend, List<InternalMail> internalMailReciever, BranchPhoneNo branchPhoneNo,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.session = session;
		this.internalMailSend = internalMailSend;
		this.internalMailReciever = internalMailReciever;
		this.branchPhoneNo = branchPhoneNo;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public User() {
		super();
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

	public List<Session> getSession() {
		return session;
	}

	public void setSession(List<Session> session) {
		this.session = session;
	}

	public List<InternalMail> getInternalMailSend() {
		return internalMailSend;
	}

	public void setInternalMailSend(List<InternalMail> internalMailSend) {
		this.internalMailSend = internalMailSend;
	}

	public List<InternalMail> getInternalMailReciever() {
		return internalMailReciever;
	}

	public void setInternalMailReciever(List<InternalMail> internalMailReciever) {
		this.internalMailReciever = internalMailReciever;
	}

	public BranchPhoneNo getBranchPhoneNo() {
		return branchPhoneNo;
	}

	public void setBranchPhoneNo(BranchPhoneNo branchPhoneNo) {
		this.branchPhoneNo = branchPhoneNo;
	}

	public CreatedUpdated getCreatedupdated() {
		return createdupdated;
	}

	public void setCreatedupdated(CreatedUpdated createdupdated) {
		this.createdupdated = createdupdated;
	}


	
	
	
	
	
}
