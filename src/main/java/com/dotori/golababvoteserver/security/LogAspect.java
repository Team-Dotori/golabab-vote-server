package com.dotori.golababvoteserver.security;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Around("execution(* com.dotori.golababvoteserver.model.*Service.*(..))") //작동 안댐
    public Object logging(ProceedingJoinPoint pjp) throws Throwable{
        log.info("start -" + pjp.getSignature().getDeclaringTypeName() + " / "+ pjp.getSignature().getName());
        Object result = pjp.proceed();
        log.info("finished - "+pjp.getSignature().getDeclaringTypeName() + " / "+ pjp.getSignature().getName());
        return result;
    }

}
