package com.winhe.institute.management.guardian;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.winhe.institute.management.student.Student;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Guardian {

	@Id
	@SequenceGenerator(name="student_generator", sequenceName="student_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_generator")
	private Long id;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date DOB;
	
	private String relationship;
	private String occupation;
	private String emailAddress;
	private String address;
	private String homeNo;
	private String mobileNo;
	
	@OneToMany(mappedBy="guardian")
	private List<Student> student;

	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param dOB
	 * @param relationship
	 * @param occupation
	 * @param emailAddress
	 * @param address
	 * @param homeNo
	 * @param mobileNo
	 * @param student
	 * @param createdupdated
	 */
	public Guardian(Long id, String firstName, String lastName, Date dOB, String relationship, String occupation,
			String emailAddress, String address, String homeNo, String mobileNo, List<Student> student,
			CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.relationship = relationship;
		this.occupation = occupation;
		this.emailAddress = emailAddress;
		this.address = address;
		this.homeNo = homeNo;
		this.mobileNo = mobileNo;
		this.student = student;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Guardian() {
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
	 * @return the relationship
	 */
	public String getRelationship() {
		return relationship;
	}

	/**
	 * @param relationship the relationship to set
	 */
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
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
	 * @return the student
	 */
	public List<Student> getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(List<Student> student) {
		this.student = student;
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
