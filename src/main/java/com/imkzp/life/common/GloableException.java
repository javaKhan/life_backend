package com.imkzp.life.common;

import com.imkzp.life.common.Base.RespResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//public class GloableException {
//
//    @Pointcut("execution( public * com.imkzp.life.controller.*.*(..))")
//    public void pointCut(){}
//
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        RespResult responseResult = null;
//        if (null==responseResult){
//            return proceedingJoinPoint.proceed();
//        }else {
//            return responseResult;
//        }
//    }
//
//}
