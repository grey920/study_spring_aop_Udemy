package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// AOP
// Configuration
@Aspect // Aspect : combination of Pointcut + advice
@Configuration
public class UserAccessAspect {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());


    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..)) - Pointcut
    // Pointcut : expression which defines what kind of method I would want to intercept.
    @Before("execution(*  com.in28minutes.spring.aop.springaop.data.*.*(..))") // 서브 패키지 안에 있는 모든 호출을 인터셉트
    public void before(JoinPoint joinPoint) { // joinPoint : specitic interception of a method call
        // advice : logic. I intercepted a method called what should I do.
        logger.info("Check for user access ");
        logger.info("Allowed execution for {}", joinPoint);
    }
    
}
