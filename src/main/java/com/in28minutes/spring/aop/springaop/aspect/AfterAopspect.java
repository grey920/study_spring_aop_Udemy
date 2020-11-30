package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class AfterAopspect {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @AfterReturning(value="execution(*  com.in28minutes.spring.aop.springaop.business.*.*(..))",
            returning ="result") // 매개변수로 들어갈 result
    public void afterReturning(JoinPoint joinPoint, Object result) { 
        logger.info("{} return with value {}", joinPoint, result);
    }
    
    @After(value="execution(*  com.in28minutes.spring.aop.springaop.business.*.*(..))") // 매개변수로 들어갈 exception
    public void after(JoinPoint joinPoint) { 
        logger.info("after execution of {}", joinPoint);
    }
}
