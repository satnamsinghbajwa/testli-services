package com.testli.data.model;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document
public class QuestionSet extends Audit {

	@Id
	private String id;
	private String description;
	@Indexed
	private String questionSetName;

	@Field("sDate")
	private Date startDate;

	@Field("eDate")
	private Date endDate;

	@Field("exDate")
	private Date expiryDate;

	@Field("pDate")
	private Date publishedDate;

	@Field("qs")
	private Set<String> questionSet;

	@DBRef
	private Audit audit;

	private String status;
	private int maxTime;

}
