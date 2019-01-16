package com.testli.data.model;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document
public class UserQuestionSet {

	@Id
	private String id;
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
	@Field("laDate")
	private Date lastAttemptedDate;
	@Field("tAttempts")
	private int totalNumberOfAttempts;
	@Field("mAttempts")
	private int maxAttempts;
	@Field("qs")
	private Set<String> questionSet;
	private int maxTime;
	@Field("acqs")
	private Set<String> attemptedCorrectQuestionSet;
	@Field("awqs")
	private Set<String> attemptedWrongQuestionSet;
	private String status;
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private Instant createdDate;
	@LastModifiedBy
	private String lastModifiedUser;
	@LastModifiedDate
	private Instant lastModifiedDate;
}
