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
	 */
	public Guardian(Long id, String firstName, String lastName, Date dOB, String relationship, String occupation,
			String emailAddress, String address, String homeNo, String mobileNo, List<Student> student) {
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
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	
	
}
