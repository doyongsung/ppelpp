package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// 동작실행
@Aspect
// 스프링에서 관리
@Component
public class ParameterAop {

             // 어디에 적용시킬 건지 controller 하위에있는 모든 메소드를 aop로 보겠다.
             // 시스템이 없어도 pointcut으로 aop 다볼수있음
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}


//    JoinPoint 들어가는 지점에 대한 정보를 가지고있는객체

    @Before("cut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();
        for(Object obj : args){
            System.out.println("Type : " +obj.getClass().getSimpleName());
            System.out.println("value : " +obj);
        }

    }

    @AfterReturning(value = "cut()",returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint,Object returnObj){
        System.out.println("return obj");
        System.out.println(returnObj);

    }

}
