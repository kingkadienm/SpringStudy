package com.example.demo.config;

import com.example.demo.interceptor.AuthInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;


/**
 * @class : WebConfig
 * @date : 2023-02-27 16:58
 * @name : wangzs
 * @description :
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Autowired
//    private TokenInterceptor tokenInterceptor;// 自定义Token拦截器


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                //拦截所有请求，通过判断token来决定是否需要登陆
                .addPathPatterns("/**");
    }

    @Bean
    public AuthInfoInterceptor jwtInterceptor() {
        return new AuthInfoInterceptor();
    }
}