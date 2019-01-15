package com.testli.data.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class QuestionPaper {

	@Id
	private String id;
	private String title;
	private String desc;
	@Indexed
	private String author;
	private String type;
	@Indexed
	@DBRef
	private Category category;
	private String status;
	private List<String> questionIds;
	private List<String> tags;

}
