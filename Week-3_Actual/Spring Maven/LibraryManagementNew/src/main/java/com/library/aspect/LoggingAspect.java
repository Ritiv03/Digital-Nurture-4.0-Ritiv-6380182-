package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("[LOG] Before method: " + joinPoint.getSignature());
    }

    @After("execution(* com.library.service.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("[LOG] After method: " + joinPoint.getSignature());
    }
}
