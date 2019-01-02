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
}
