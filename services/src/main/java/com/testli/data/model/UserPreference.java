package com.testli.data.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.testli.data.constants.NotificationType;

import lombok.Data;

@Document
@Data
public class UserPreference {

	private String locale;
	private String timeZone;
	private boolean isNotificationEnaled;
	private NotificationType notificationType;
	private List<Category> interestes;

}
