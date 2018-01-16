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

}
