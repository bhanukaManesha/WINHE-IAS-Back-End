package com.winhe.institute.management.branchPhoneNo;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.user.User;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

public class BranchPhoneNo {

	@Id
	@SequenceGenerator(name="branchphoneno_generator", sequenceName="branchphoneno_seq", allocationSize = 1, initialValue = 50)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="branchphoneno_generator")
	private Long id;
	
	private String branchPhoneNo;
	
	@ManyToOne
	private Integer branchId;
	
	@OneToMany(mappedBy="branchPhoneNo")
	private List<User> userId;
	
	private CreatedUpdated createdupdated;
	
	
}
