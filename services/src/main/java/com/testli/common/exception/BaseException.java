package com.testli.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;

	public BaseException(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
