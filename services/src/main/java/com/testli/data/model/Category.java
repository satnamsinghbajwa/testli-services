package com.testli.data.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Category {

	@Id
	private String id;
	private String name;
	private String description;
	private String status;
	private Audit audit;
	@Indexed
	private List<String> childrenIds;
	@Indexed
	private String parentId;
}
