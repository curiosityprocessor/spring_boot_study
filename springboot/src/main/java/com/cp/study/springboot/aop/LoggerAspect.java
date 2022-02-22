package com.cp.study.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggerAspect {
    public enum LayerType {
        CONTROLLER, SERVICE, MAPPER, UNKNOWN
    }

    public static final String CONTROLLER = "Controller";
    public static final String SERVICE = "Service";
    public static final String SERVICE_IMPL = "ServiceImpl";
    public static final String MAPPER = "Mapper";

    public static final String LOG_FORMAT = "[{}] {}.{}()";
    
    @Around(
        "execution(* cp..*Controller.*(..)) or execution(* cp..*ServiceImpl.*(..)) or execution(* cp..*Mapper.*(..))"
    )
    public Object printSystemLog(ProceedingJoinPoint jointPoint) throws Throwable {
        String name = jointPoint.getSignature().getDeclaringTypeName();
        LayerType type = getLayerTypeFromName(name);
        log.info(LOG_FORMAT, type.toString(), name, jointPoint.getSignature().getName());
        return jointPoint.proceed();
        
    }

    private LayerType getLayerTypeFromName(String name) {
        if(name.contains(CONTROLLER)) {
            return LayerType.CONTROLLER;
        } else if(name.contains(SERVICE) || name.contains(SERVICE_IMPL)) {
            return LayerType.SERVICE;
        } else if(name.contains(MAPPER)) {
            return LayerType.MAPPER;
        } else {
            return LayerType.UNKNOWN;
        }
    }
}
