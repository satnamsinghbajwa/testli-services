package com.testli.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Benefit {

	@Id
	private String id;
	private String name;
	private String description;
	private String status;
	private Audit audit;
	
}
