package com.winhe.institute.management.associate.batch_branch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.branch.Branch;
import com.winhe.institute.management.course.Course;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Batch_Branch {
	
	@Id
	private Long id;
	
	@ManyToOne
	private Batch batch;
	@ManyToOne
	private Branch branch;
	@ManyToOne
	private Course course;
	
	private CreatedUpdated createdupdated; 
	
	/**
	 * @param id
	 * @param batch
	 * @param branch
	 * @param course
	 * @param createdupdated
	 */
	public Batch_Branch(Long id, Batch batch, Branch branch, Course course, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.batch = batch;
		this.branch = branch;
		this.course = course;
		this.createdupdated = createdupdated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CreatedUpdated getCreatedupdated() {
		return createdupdated;
	}

	public void setCreatedupdated(CreatedUpdated createdupdated) {
		this.createdupdated = createdupdated;
	}
	
	


	

}
