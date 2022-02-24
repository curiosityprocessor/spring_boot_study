package com.cp.study.springboot.config;

import com.cp.study.springboot.interceptor.BaseInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    BaseInterceptor baseInterceptor;

    @Autowired
    LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // WebMvcConfigurer.super.addInterceptors(registry);
        InterceptorRegistration ir = registry.addInterceptor(baseInterceptor);
        ir.addPathPatterns("/**");

        registry.addInterceptor(loggerInterceptor);
    }
}
