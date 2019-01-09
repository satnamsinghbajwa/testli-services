package com.testli.data;

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
public class UserQuestionSet {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionSetName() {
		return questionSetName;
	}

	public void setQuestionSetName(String questionSetName) {
		this.questionSetName = questionSetName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Date getLastAttemptedDate() {
		return lastAttemptedDate;
	}

	public void setLastAttemptedDate(Date lastAttemptedDate) {
		this.lastAttemptedDate = lastAttemptedDate;
	}

	public int getTotalNumberOfAttempts() {
		return totalNumberOfAttempts;
	}

	public void setTotalNumberOfAttempts(int totalNumberOfAttempts) {
		this.totalNumberOfAttempts = totalNumberOfAttempts;
	}

	public int getMaxAttempts() {
		return maxAttempts;
	}

	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}

	public Set<String> getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(Set<String> questionSet) {
		this.questionSet = questionSet;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public Set<String> getAttemptedCorrectQuestionSet() {
		return attemptedCorrectQuestionSet;
	}

	public void setAttemptedCorrectQuestionSet(Set<String> attemptedCorrectQuestionSet) {
		this.attemptedCorrectQuestionSet = attemptedCorrectQuestionSet;
	}

	public Set<String> getAttemptedWrongQuestionSet() {
		return attemptedWrongQuestionSet;
	}

	public void setAttemptedWrongQuestionSet(Set<String> attemptedWrongQuestionSet) {
		this.attemptedWrongQuestionSet = attemptedWrongQuestionSet;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
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
	@DBRef
	private Audit audit;
}
