package com.example.demo.interceptor;

import com.alibaba.druid.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Enumeration;

/**
 * @class : HandlerInterceptor
 * @date : 2023-02-27 16:33
 * @name : wangzs
 * @description :
 */
@Component
public class AuthInfoInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String s = headerNames.nextElement();
//            String header = request.getHeader(s);
//            logger.error(String.format("header`s key is %s value is %s", s, header));
//        }
//        String app = request.getHeader("app");
//        if (StringUtils.isEmpty(app)){
//            response.sendError(400,"111");
//          return false;
//        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
