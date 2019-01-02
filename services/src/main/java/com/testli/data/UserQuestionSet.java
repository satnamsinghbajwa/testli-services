package com.testli.data;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class UserQuestionSet {

	@Id
	private String id;
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
	@DBRef
	private Audit audit;
}
