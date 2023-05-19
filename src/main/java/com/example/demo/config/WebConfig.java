package com.example.demo.config;

import com.example.demo.interceptor.AuthInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

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


    // springMVC中的方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 相当于把后面位置那部分起个别名，外部可以通过别名直接访问，但是直接访问上传路径是不行的
        // registry.addResourceHandler(访问的路径).addResourceLocations(上传的路径);
        // 这个mapPath在本地测试的时候可以用到

     }

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