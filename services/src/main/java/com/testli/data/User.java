package com.testli.data;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	@Indexed
	private String emailId;
	private String phoneNumber;
	private String status;
	private List<UserQuestionSet> listOfUserQuestionSet;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<UserQuestionSet> getListOfUserQuestionSet() {
		return listOfUserQuestionSet;
	}
	public void setListOfUserQuestionSet(List<UserQuestionSet> listOfUserQuestionSet) {
		this.listOfUserQuestionSet = listOfUserQuestionSet;
	}
	
	
}
