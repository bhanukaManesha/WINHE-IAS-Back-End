package com.winhe.institute.management.timetable;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.winhe.institute.management.batch.Batch;
import com.winhe.institute.management.upload.Upload;
import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Timetable {

	@Id
	@SequenceGenerator(name="timetable_generator", sequenceName="timetable_seq", allocationSize = 1, initialValue = 1000)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="timetable_generator")
	private Long id;
	
	@ManyToOne
	private Batch batch;
	
	@ManyToOne
	private Upload upload;
	
	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param batch
	 * @param upload
	 * @param createdupdated
	 */
	public Timetable(Long id, Batch batch, Upload upload, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.batch = batch;
		this.upload = upload;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Timetable() {
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
	 * @return the batch
	 */
	public Batch getBatch() {
		return batch;
	}

	/**
	 * @param batch the batch to set
	 */
	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	/**
	 * @return the upload
	 */
	public Upload getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(Upload upload) {
		this.upload = upload;
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
