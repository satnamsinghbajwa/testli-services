package com.testli.common.exception;

import lombok.Data;

@Data
public class ApiErrorResponse {

	private String code;
	private String message;

	public ApiErrorResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
