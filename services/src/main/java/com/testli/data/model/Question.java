package com.testli.data.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Question {

	@Id
	private String id;
	private String title;
	private String desc;
	@Indexed
	private String author;
	private List<String> options;
	private String answer;
	private String type;
	@Indexed
	private String category;
	private String subCategory;
	private String status;
	@DBRef
	private Audit audit;
	@DBRef
	private ReferenceMaterial referenceMaterial;
}
