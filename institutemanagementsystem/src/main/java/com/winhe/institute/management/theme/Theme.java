package com.winhe.institute.management.theme;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Theme {
	
	@Id
	private Long id;
	private String themeName;

}
