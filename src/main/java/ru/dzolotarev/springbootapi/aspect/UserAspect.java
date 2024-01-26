package ru.dzolotarev.springbootapi.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class UserAspect {

    // all methods in service
    @Pointcut("within(ru.dzolotarev.springbootapi.service.*)")
    public void allServiceMethodsPointcut() {
    }

    //all overloaded saveUser() methods in service
    @Pointcut("execution(public * ru.dzolotarev.springbootapi.service.UserService.save(..))")

    public void callAllPublicSaveMethodsInService() {
    }

    // Advice used pointcut
    @Before("allServiceMethodsPointcut()")
    public void loggingAdvice() {
        log.info("Executing before method invocation in service");
    }

    // Advice used pointcut
    @Before("callAllPublicSaveMethodsInService()")
    public void beforeCallAllMethods(JoinPoint joinPoint) {
        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("before {} , args = [{}]", joinPoint, args);
    }

    // Advice used pointcut
    @After("callAllPublicSaveMethodsInService()")
    public void afterCallAllMethods(JoinPoint joinPoint) {
        log.info("after " + joinPoint.getSignature().getName());
    }

    // Advice with inline pointcut
    @Around("within(ru.dzolotarev.springbootapi.service.UserService)")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("Before invoking method {}", proceedingJoinPoint.getSignature());

        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.toString());
        }

        log.info("After invoking method {}, value = {}", proceedingJoinPoint.getSignature(), value);
        return value;
    }
}
