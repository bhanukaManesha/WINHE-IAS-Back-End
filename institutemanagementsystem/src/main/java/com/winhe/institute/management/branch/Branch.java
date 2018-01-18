package com.winhe.institute.management.branch;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.branchPhoneNo.BranchPhoneNo;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Branch {

	@Id
	@SequenceGenerator(name="branch_generator", sequenceName="branch_seq", allocationSize = 1, initialValue = 50)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="branch_generator")
	private Long id;
	
	private String branchName;
	private String branchLocation;
	
	@OneToMany(mappedBy="branchId")
	private List<BranchPhoneNo> branchPhoneNo;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param branchName
	 * @param branchLocation
	 * @param branchPhoneNo
	 * @param createdupdated
	 */
	public Branch(Long id, String branchName, String branchLocation, List<BranchPhoneNo> branchPhoneNo,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.branchLocation = branchLocation;
		this.branchPhoneNo = branchPhoneNo;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Branch() {
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
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the branchLocation
	 */
	public String getBranchLocation() {
		return branchLocation;
	}

	/**
	 * @param branchLocation the branchLocation to set
	 */
	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	/**
	 * @return the branchPhoneNo
	 */
	public List<BranchPhoneNo> getBranchPhoneNo() {
		return branchPhoneNo;
	}

	/**
	 * @param branchPhoneNo the branchPhoneNo to set
	 */
	public void setBranchPhoneNo(List<BranchPhoneNo> branchPhoneNo) {
		this.branchPhoneNo = branchPhoneNo;
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
