package com.testli.aop;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
public class LoggerFormatter {

	private static final String CLASS_VALUE = "class.name";
	private static final String METHDO_VALUE = "method.name";
	private static final String ARGS_VALUE = "method.args";
	private static final String RESULT_VALUE = "method.result";
	private static final String DURATION_VALUE = "method.duration";

	public String formatArguments(ProceedingJoinPoint joinPoint, Loggable loggable) {
		Map<String, Object> values = new HashMap<>();
		values.put(CLASS_VALUE, className(joinPoint));
		values.put(METHDO_VALUE, methodName(joinPoint));
		values.put(ARGS_VALUE, argsToString(joinPoint.getArgs()));
		return values.toString();
	}

	public String formatResults(ProceedingJoinPoint joinPoint, Loggable loggable, Object result, long nano) {
		Map<String, Object> values = new HashMap<>();
		values.put(CLASS_VALUE, className(joinPoint));
		values.put(METHDO_VALUE, methodName(joinPoint));
		values.put(DURATION_VALUE, durationString(nano));
		values.put(RESULT_VALUE, result);
		return values.toString();
	}

	private Object className(ProceedingJoinPoint joinPoint) {
		return joinPoint.getTarget().getClass().getName();
	}

	private String methodName(JoinPoint joinPoint) {
		return MethodSignature.class.cast(joinPoint.getSignature()).getMethod().getName();
	}

	private String argsToString(Object arg) {
		String text;
		if (arg == null) {
			return "NULL";
		} else if (arg.getClass().isArray()) {
			if (arg instanceof Object[]) {
				text = objectArraysToString((Object[]) arg);
			} else {
				text = primitiveArrayToString(arg);
			}
		} else {
			String origin = arg.toString();
			if (arg instanceof String || origin.isEmpty()) {
				text = String.format("'%s'", origin);
			} else {
				text = origin;
			}
		}
		return text;
	}

	private String objectArraysToString(Object... arg) {
		StringBuilder bldr = new StringBuilder();
		bldr.append('[');
		for (Object item : arg) {
			if (bldr.length() > 1) {
				bldr.append(",").append(" ");
			}
			bldr.append(argsToString(item));
		}
		return bldr.append(']').toString();
	}

	private String primitiveArrayToString(Object arg) {
		String text;
		if (arg instanceof char[]) {
			text = Arrays.toString((char[]) arg);
		} else if (arg instanceof byte[]) {
			text = Arrays.toString((byte[]) arg);
		} else if (arg instanceof short[]) {
			text = Arrays.toString((short[]) arg);
		} else if (arg instanceof int[]) {
			text = Arrays.toString((int[]) arg);
		} else if (arg instanceof long[]) {
			text = Arrays.toString((long[]) arg);
		} else if (arg instanceof float[]) {
			text = Arrays.toString((float[]) arg);
		} else if (arg instanceof double[]) {
			text = Arrays.toString((double[]) arg);
		} else if (arg instanceof boolean[]) {
			text = Arrays.toString((boolean[]) arg);
		} else {
			text = "[unknown]";
		}
		return text;
	}

	private long durationString(long nano) {
		return Duration.ofMillis(TimeUnit.NANOSECONDS.toMillis(nano)).toMillis();
	}
}
