package com.testli.data;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class ReferenceMaterial {
	
	@Id
	private String id;
	private List<String> urls;
	private String type;
}
	