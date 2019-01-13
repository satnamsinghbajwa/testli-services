package com.testli.data.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Device {
	
	@Id
	private String id;
	private String name;
	private String httpVersion;
	private String osVersion;
	private String appVersion;
	private String deviceType;	
	private String type;
	private Date createDate;
	private Date modifiedDate;
	private String createBy;
	private String modifiedBy;
	private String status;
}
