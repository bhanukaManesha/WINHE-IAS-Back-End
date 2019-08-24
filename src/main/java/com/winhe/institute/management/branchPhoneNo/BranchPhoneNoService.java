package com.winhe.institute.management.branchPhoneNo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class  BranchPhoneNoService {

	@Autowired
	private BranchPhoneNoRepository branchPhoneNoRepository;
	
	public JsonWrapper getAllBranchPhoneNo(){
		
		JsonWrapper data = new JsonWrapper("BRANCHPHONENO200", "List of All the Branch Phone No", branchPhoneNoRepository.findAll());
		
		return data;
	};
	
	public JsonWrapper getBranchPhoneNo(String id){
		
		BranchPhoneNo branchPhoneNo = branchPhoneNoRepository.findOne(Long.valueOf(id));

		if (branchPhoneNo == null) { 
			JsonWrapper data = new JsonWrapper("BRANCHPHONENO404", "ERROR , No Branch Phone Number Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("BRANCHPHONENO200", "Branch Phone No Found", branchPhoneNo);

		return data;
		
		
	};
	
	public JsonWrapper addBranchPhoneNo(BranchPhoneNo branchPhoneNo) {

		branchPhoneNoRepository.save(branchPhoneNo);

		JsonWrapper data = new JsonWrapper("BRANCHPHONENO200", "Branch Phone No Successfully Added", branchPhoneNo);

		return data;
	};
	
	public JsonWrapper updateBranchPhoneNo(Long id, BranchPhoneNo branchPhoneNo) {

		BranchPhoneNo tempBranchPhoneNo = branchPhoneNoRepository.findOne(id);

		if (tempBranchPhoneNo == null) {
			JsonWrapper data = new JsonWrapper("BRANCHPHONENO404", "ERROR , No Branch Phone Number Found");
			return data;
		}

		branchPhoneNo.setId(id);
		branchPhoneNoRepository.save(branchPhoneNo);
		
		JsonWrapper data = new JsonWrapper("BRANCHPHONENO200", "Branch Phone No Successfully Updated", branchPhoneNo);

		return data;
	};
	
	public JsonWrapper deleteBranchPhoneNo(Long id) {

		BranchPhoneNo tempBranchPhoneNo = branchPhoneNoRepository.findOne(id);

		if (tempBranchPhoneNo == null) {
			JsonWrapper data = new JsonWrapper("BRANCHPHONENO404", "ERROR , No Branch Phone Number Found");
			return data;
		}

		branchPhoneNoRepository.delete(id);

		JsonWrapper data = new JsonWrapper("BRANCHPHONENO200", "SUCCESFULLY DELETED");

		return data;
	};

}
