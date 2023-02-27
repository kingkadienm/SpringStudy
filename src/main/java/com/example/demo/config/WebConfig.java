package com.example.demo.config;

import com.example.demo.interceptor.AuthInfoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @class : WebConfig
 * @date : 2023-02-27 16:58
 * @name : wangzs
 * @description :
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

       registry.addInterceptor(new AuthInfoInterceptor());

    }
}
