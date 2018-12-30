package com.testli.data;

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
}
