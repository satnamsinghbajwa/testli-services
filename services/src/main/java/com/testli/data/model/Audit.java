package com.testli.data.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document
@Data
public class Audit {
	
	@Id
	private String id;
	@Field("uB")
	private String updatedBy;
	@Field("uT")
	private Date updatedTime;
	@Field("uV")
	private String updatedValue;

	public Audit() {
		this.updatedBy = "SYSTEM";
		this.updatedTime = new Date();
		this.updatedValue = "SYSTEM";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdatedValue() {
		return updatedValue;
	}

	public void setUpdatedValue(String updatedValue) {
		this.updatedValue = updatedValue;
	}
	
}
