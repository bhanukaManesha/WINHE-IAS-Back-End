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
	private Integer branchPhoneNo;
	
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
	 * @param createdupdated
	 */
	public User(Integer id, String userName, String email, String password, Role role, List<Session> session,
			List<InternalMail> internalMailSend, List<InternalMail> internalMailReciever,
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
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public User() {
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the session
	 */
	public List<Session> getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(List<Session> session) {
		this.session = session;
	}

	/**
	 * @return the internalMailSend
	 */
	public List<InternalMail> getInternalMailSend() {
		return internalMailSend;
	}

	/**
	 * @param internalMailSend the internalMailSend to set
	 */
	public void setInternalMailSend(List<InternalMail> internalMailSend) {
		this.internalMailSend = internalMailSend;
	}

	/**
	 * @return the internalMailReciever
	 */
	public List<InternalMail> getInternalMailReciever() {
		return internalMailReciever;
	}

	/**
	 * @param internalMailReciever the internalMailReciever to set
	 */
	public void setInternalMailReciever(List<InternalMail> internalMailReciever) {
		this.internalMailReciever = internalMailReciever;
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
