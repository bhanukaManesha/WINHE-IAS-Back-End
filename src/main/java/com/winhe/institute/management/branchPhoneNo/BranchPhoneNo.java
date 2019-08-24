package com.winhe.institute.management.branchPhoneNo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.branch.Branch;
import com.winhe.institute.management.user.User;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class BranchPhoneNo {

	@Id
	@SequenceGenerator(name="branchphoneno_generator", sequenceName="branchphoneno_seq", allocationSize = 1, initialValue = 50)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="branchphoneno_generator")
	private Long id;
	
	private String branchPhoneNo;
	
	@ManyToOne
	private Branch branchId;
	
	@OneToMany(mappedBy="branchPhoneNo")
	private List<User> user;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param branchPhoneNo
	 * @param branchId
	 * @param user
	 * @param createdupdated
	 */
	public BranchPhoneNo(Long id, String branchPhoneNo, Branch branchId, List<User> user,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.branchPhoneNo = branchPhoneNo;
		this.branchId = branchId;
		this.user = user;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public BranchPhoneNo() {
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
	 * @return the branchPhoneNo
	 */
	public String getBranchPhoneNo() {
		return branchPhoneNo;
	}

	/**
	 * @param branchPhoneNo the branchPhoneNo to set
	 */
	public void setBranchPhoneNo(String branchPhoneNo) {
		this.branchPhoneNo = branchPhoneNo;
	}

	/**
	 * @return the branchId
	 */
	public Branch getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Branch branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the user
	 */
	public List<User> getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(List<User> user) {
		this.user = user;
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
