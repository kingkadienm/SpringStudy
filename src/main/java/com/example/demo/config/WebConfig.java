package com.example.demo.config;

import com.example.demo.interceptor.AuthInfoInterceptor;
import com.example.demo.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @class : WebConfig
 * @date : 2023-02-27 16:58
 * @name : wangzs
 * @description :
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TokenInterceptor tokenInterceptor;// 自定义Token拦截器

    @Autowired
    AuthInfoInterceptor authInfoInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**");
        registry.addInterceptor(authInfoInterceptor)
                .addPathPatterns("/**")
//                表示取消对特定路径的拦截
                .excludePathPatterns("/login")
                .excludePathPatterns("/loginCheck")
//                这里一定不要写成/**/*.js的形式，spring boot无法识别
//                取消对static目录下静态资源的拦截
                .excludePathPatterns("/static/**");
        super.addInterceptors(registry);
    }


}
