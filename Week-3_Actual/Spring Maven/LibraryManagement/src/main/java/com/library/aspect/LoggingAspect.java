package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();  // execute the method

        long duration = System.currentTimeMillis() - start;
        System.out.println("Execution time of " + method + ": " + duration + " ms");

        return result;
    }
}
