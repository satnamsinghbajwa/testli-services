package com.testli.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MDCInterceptor implements HandlerInterceptor {

	private static final String HEADER_X_FORWARDED_FOR = "X-Forwarded-For";
	private static final String HEADER_X_CORRELATION_ID = "X-Correlation-ID";
	private static final String PREFIX_CORRELATION_ID = "testli-svc_";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String correlationId = request.getHeader(HEADER_X_CORRELATION_ID);
		correlationId = correlationId != null ? correlationId : PREFIX_CORRELATION_ID + UUID.randomUUID().toString();
		String remoteAddress = request.getHeader(HEADER_X_FORWARDED_FOR);
		remoteAddress = remoteAddress != null ? remoteAddress : request.getRemoteAddr();
		ThreadContext.put("correlationId", correlationId);
		ThreadContext.put("remoteAddress", remoteAddress);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		ThreadContext.clearAll();
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
