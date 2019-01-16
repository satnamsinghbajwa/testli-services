package com.testli.data.model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.testli.data.constants.MembershipType;

import lombok.Data;

@Document
@Data
public class Membership {

	@Id
	private String id;
	private MembershipType membershipType;
	private String description;
	private List<Benefit> benefits;
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
