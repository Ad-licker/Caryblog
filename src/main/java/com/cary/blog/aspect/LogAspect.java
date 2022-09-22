package com.cary.blog.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private final Logger logger =LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.cary.blog.web.*.*(..))")
    public void log() {}

    //在执行controller之前before来打印请求的信息
    @Before("log()")
    public void doBefore(){
        logger.info("--------doBefore--------");
    }
    @After("log()")
    public void doAfter(){
        logger.info("--------doAfter--------");
    }
    //有返回结果则打印，异常则不打印。但是After一定最后会打印，相当于finally
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result){
        logger.info("result:{}",result);
    }

}
