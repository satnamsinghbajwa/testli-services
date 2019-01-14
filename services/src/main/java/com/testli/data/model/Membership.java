package com.testli.data.model;

import java.util.List;

import org.springframework.data.annotation.Id;
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
	private Audit audit;

}
