package com.testli.data.model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
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
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private Instant createdDate;
	@LastModifiedBy
	private String lastModifiedUser;
	@LastModifiedDate
	private Instant lastModifiedDate;
}
