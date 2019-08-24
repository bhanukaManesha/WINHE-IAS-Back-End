package com.winhe.institute.management.associate.batch_branch;

import javax.swing.plaf.basic.BasicTableHeaderUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winhe.institute.management.associate.student_course.Student_Course;
import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@Service
public class Batch_Branch_Service {

	@Autowired
	private Batch_Branch_Repository batch_Branch_Repository;

	public JsonWrapper getAllBatchBranch() {

		JsonWrapper data = new JsonWrapper("BATCHBRANCH200", "List All Batch Branch Entries",
				batch_Branch_Repository.findAll());
		return data;
	};

	public JsonWrapper getBatchBranch(String id) {
		Batch_Branch batch_Branch = batch_Branch_Repository.findOne(Long.valueOf(id));
		if (batch_Branch == null) {
			JsonWrapper data = new JsonWrapper("BATCHBRANCH404", "ERROR , No Batch Branch Entry Found");
			return data;
		}

		JsonWrapper data = new JsonWrapper("BATCHBRANCH200", "Batch Branch Entry  Found", batch_Branch);

		return data;
	};

	public JsonWrapper addBatchBranch(Batch_Branch batch_Branch) {
		batch_Branch_Repository.save(batch_Branch);

		JsonWrapper data = new JsonWrapper("BATCHBRANCH200", "Batch Branch Entry  Successfully Added", batch_Branch);

		return data;
	}

	public JsonWrapper updateBatchBranch(Long id, Batch_Branch batch_Branch) {
		Batch_Branch tempBatch_Branch = batch_Branch_Repository.findOne(id);
		if (tempBatch_Branch == null) {
			JsonWrapper data = new JsonWrapper("BATCHBRANCH404", "ERROR , No Batch Branch Entry  Found");
			return data;
		}

		batch_Branch.setId(id);
		batch_Branch_Repository.save(batch_Branch);

		JsonWrapper data = new JsonWrapper("BATCHBRANCH200", "Batch Branch Entry  Successfully Updated", batch_Branch);

		return data;

	};;

	public JsonWrapper deleteBatchBranch(Long id) {
		Batch_Branch tempBatch_Branch = batch_Branch_Repository.findOne(id);

		if (tempBatch_Branch == null) {
			JsonWrapper data = new JsonWrapper("BATCHBRANCH404", "ERROR , No Student Course Entry  Found");
			return data;

		}
		batch_Branch_Repository.delete(id);
		JsonWrapper data = new JsonWrapper("BATCHBRANCH200", "SUCCESFULLY DELETED");

		return data;

	}

}
