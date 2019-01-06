package com.testli.aop;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger logger = LogManager.getLogger(LoggingAspect.class);

	@Autowired
	private LoggerFormatter loggerFormatter;

	@Pointcut("execution(public * *(..))" + " && !execution(String *.toString())" + " && !execution(int *.hashCode())"
			+ " && !execution(boolean *.canEqual(Object))" + " && !execution(boolean *.equals(Object))")

	protected void publicMethod() {
	}

	@Pointcut("@annotation(loggable)")
	protected void loggableMethod(Loggable loggable) {
	}

	@Pointcut("@within(loggable)")
	protected void loggableClass(Loggable loggable) {
	}

	@Around(value = "publicMethod() && loggableMethod(loggable)", argNames = "joinPoint,loggable")
	public Object logExecutionMethod(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
		return logMethod(joinPoint, loggable);
	}

	@Around(value = "publicMethod() && loggableClass(loggable) && !loggableMethod(com.testli.aop.Loggable)", argNames = "joinPoint,loggable")
	public Object logExecutionClass(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
		return logMethod(joinPoint, loggable);
	}

	public Object logMethod(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
		long start = System.nanoTime();
		long duration;
		Object returnVal = null;
		try {
			logger.log(Level.valueOf(loggable.value().name()), loggerFormatter.formatArguments(joinPoint, loggable));
			returnVal = joinPoint.proceed();
			duration = System.nanoTime() - start;
			logger.log(Level.valueOf(loggable.value().name()),
					loggerFormatter.formatResults(joinPoint, loggable, returnVal, duration));
			return returnVal;
		} catch (Throwable ex) {
			duration = System.nanoTime() - start;
			logger.log(Level.ERROR, loggerFormatter.formatResults(joinPoint, loggable, returnVal, duration), ex);
			throw ex;
		}
	}

}
