package com.winhe.institute.management.inquiry;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Inquiry {

	@Id
	@SequenceGenerator(name="inquiry_generator", sequenceName="inquiry_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inquiry_generator")
	private Long id;

	private String firstName;
	private String lastName;
	private String NIC_BC;
	@Temporal(TemporalType.DATE)
	private Date DOB;
	private String gender;
	private String emailAddress;
	private String address;
	private String homeNo;
	private String mobileNo;
	private String studyTime;
	
	@ManyToOne
	private Batch intrested_batch;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param nIC_BC
	 * @param dOB
	 * @param gender
	 * @param emailAddress
	 * @param address
	 * @param homeNo
	 * @param mobileNo
	 * @param studyTime
	 * @param intrested_batch
	 * @param createdupdated
	 */
	public Inquiry(Long id, String firstName, String lastName, String nIC_BC, Date dOB, String gender,
			String emailAddress, String address, String homeNo, String mobileNo, String studyTime,
			Batch intrested_batch, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		NIC_BC = nIC_BC;
		DOB = dOB;
		this.gender = gender;
		this.emailAddress = emailAddress;
		this.address = address;
		this.homeNo = homeNo;
		this.mobileNo = mobileNo;
		this.studyTime = studyTime;
		this.intrested_batch = intrested_batch;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Inquiry() {
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the nIC_BC
	 */
	public String getNIC_BC() {
		return NIC_BC;
	}

	/**
	 * @param nIC_BC the nIC_BC to set
	 */
	public void setNIC_BC(String nIC_BC) {
		NIC_BC = nIC_BC;
	}

	/**
	 * @return the dOB
	 */
	public Date getDOB() {
		return DOB;
	}

	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the homeNo
	 */
	public String getHomeNo() {
		return homeNo;
	}

	/**
	 * @param homeNo the homeNo to set
	 */
	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the studyTime
	 */
	public String getStudyTime() {
		return studyTime;
	}

	/**
	 * @param studyTime the studyTime to set
	 */
	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
	}

	/**
	 * @return the intrested_batch
	 */
	public Batch getIntrested_batch() {
		return intrested_batch;
	}

	/**
	 * @param intrested_batch the intrested_batch to set
	 */
	public void setIntrested_batch(Batch intrested_batch) {
		this.intrested_batch = intrested_batch;
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
