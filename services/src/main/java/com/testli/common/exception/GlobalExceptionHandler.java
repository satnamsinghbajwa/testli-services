package com.testli.common.exception;

import org.springframework.http.HttpHeaders;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	protected ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException be, WebRequest request) {
		return handleExceptionInternal(be, new ApiErrorResponse(be.getCode(), be.getMessage()), new HttpHeaders(),
				NOT_FOUND, request);
	}
}
