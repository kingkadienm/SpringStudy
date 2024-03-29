package com.example.demo.interceptor;

import cn.hutool.core.text.CharSequenceUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.bean.User;
import com.example.demo.enums.ResponseEnum;
import com.example.demo.repository.UserRepository;
import com.example.demo.tools.PassToken;
import com.example.demo.utils.MyException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @class : HandlerInterceptor
 * @date : 2023-02-27 16:33
 * @name : wangzs
 * @description : 获取token并验证
 */

@Component
@Log4j2
public class AuthInfoInterceptor implements HandlerInterceptor {
    @Autowired
    private UserRepository adminService;


    @Value("${custom-configure.token-verify}")
    boolean customTokenVerify;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.error(request.getRequestURI());

        //是否开启token校验
        if (!customTokenVerify){
            return true;
        }

        if (request.getRequestURI().contentEquals("/error")) {
            return true;
        }
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否通过有PassToken注解

        if (method.isAnnotationPresent(PassToken.class)) {
            //如果有则跳过认证检查
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //否则进行token检查
        if (CharSequenceUtil.isBlank(token)) {
            throw new MyException(
                    ResponseEnum.TOKEN_EX.getCode(), ResponseEnum.TOKEN_EX.getResultMessage());
        }
        //获取token中的用户id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new MyException(ResponseEnum.TOKEN_EX.getCode(), ResponseEnum.TOKEN_EX.getResultMessage());
        }
        //根据token中的userId查询数据库
        User user = adminService.findUserByUserId(userId);
        if (user == null) {
            throw new MyException(ResponseEnum.USER_EX.getCode(), ResponseEnum.USER_EX.getResultMessage());
        }
//        String password = request.getParameter("password");
//        String userName = request.getParameter("userName");

        //验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUserPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (
                JWTVerificationException e) {
            throw new MyException(406, "权限验证失败！请重新登录");
        }
        return true;
    }
}
