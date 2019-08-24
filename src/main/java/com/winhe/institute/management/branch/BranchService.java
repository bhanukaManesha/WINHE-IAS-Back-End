package com.winhe.institute.management.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class BranchService {

	@Autowired
	private BranchRepository branchRepository;

	public JsonWrapper getAllBranches() {

		JsonWrapper data = new JsonWrapper("BRANCH200", "List of All the Branches", branchRepository.findAll());

		return data;
	}

	public JsonWrapper getBranch(String id) {
		Branch branch = branchRepository.findOne(Long.valueOf(id));

		if (branch == null) {
			JsonWrapper data = new JsonWrapper("BRANCH404", "ERROR", "No Branch Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("BRANCH200", "Branch Found", branch);
		return data;
	}
	
	// method of adding a branch
	public JsonWrapper addBranch(Branch branch) {
		
		branchRepository.save(branch);
		
		JsonWrapper data = new JsonWrapper("Branch200", "SUCCESSFULLY ADDED", branch);
	
		return data;
	}
	
	// method of updating a branch
	public JsonWrapper updateBranch(Long id,  Branch branch) {

		Branch tempBranch = branchRepository.findOne(id);

		if (tempBranch== null) {
			JsonWrapper data = new JsonWrapper("BRANCH404", "ERROR , No Branch Entry Found");
			return data;
		}

		branch.setId(id);
		branchRepository.save(branch);
		
		JsonWrapper data = new JsonWrapper("BRANCH200", "Branch Entry Successfully Updated", branch);

		return data;
	};
	
	// method of deleting a branch
	public JsonWrapper deleteBranch(Long id) {

		Branch tempBranch = branchRepository.findOne(id);

		if (tempBranch == null) {
			JsonWrapper data = new JsonWrapper("BRANCH404", "ERROR , No Branch Entry Found");
			return data;
		}

		branchRepository.delete(id);

		JsonWrapper data = new JsonWrapper("Branch200", "SUCCESFULLY DELETED");

		return data;
	};
	
}
