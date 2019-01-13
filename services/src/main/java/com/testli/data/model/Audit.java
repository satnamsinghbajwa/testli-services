package com.testli.data.model;

import java.util.Date;


public class Audit {
	
	private String createdBy;
	private Date createdDate;

	private String modifiedBy;
	private Date modifiedDate;

	public Audit() {
		super();
		this.createdBy = "System";
		this.createdDate = new Date();
		this.modifiedBy = "System";
		this.modifiedDate = new Date();
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
