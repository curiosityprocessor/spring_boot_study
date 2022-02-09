package com.cp.study.springboot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BaseInterceptor implements HandlerInterceptor {
    private static final String START_LOG_FORMAT = "[Interceptor] START\trequestUri: {}";
    private static final String END_LOG_FORMAT = "[Interceptor] END\trequestUri: {}";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        //TODO apply XSS protection
        String requestUri = request.getRequestURI();
        log.info(START_LOG_FORMAT, requestUri);


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //TODO apply XSS protection
        String requestUri = request.getRequestURI();
        log.info(END_LOG_FORMAT, requestUri);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
