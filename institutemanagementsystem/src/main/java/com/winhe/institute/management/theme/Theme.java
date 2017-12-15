package com.winhe.institute.management.theme;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.winhe.institute.management.util.created_updated.CreatedUpdated;

@Entity
public class Theme {
	
	@Id
	private Long id;
	private String themeName;

	private CreatedUpdated createdupdated;

	/**
	 * @param id
	 * @param themeName
	 * @param createdupdated
	 */
	public Theme(Long id, String themeName, CreatedUpdated createdupdated) {
		super();
		this.id = id;
		this.themeName = themeName;
		this.createdupdated = createdupdated;
	}

	/**
	 * 
	 */
	public Theme() {
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
	 * @return the themeName
	 */
	public String getThemeName() {
		return themeName;
	}

	/**
	 * @param themeName the themeName to set
	 */
	public void setThemeName(String themeName) {
		this.themeName = themeName;
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
