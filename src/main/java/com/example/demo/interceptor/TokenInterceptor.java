package com.example.demo.interceptor;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.demo.tools.PassToken;
import com.example.demo.tools.UserLoginToken;
import com.example.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final static Log logger = LogFactory.getLog(TokenInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //检查方法是否有passtoken注解，有则跳过认证，直接通过
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String phone;
                try {
                    phone = JWT.decode(token).getClaim("phone").asString();
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("token不正确，请不要通过非法手段创建token");
                }
                //查询数据库，看看是否存在此用户，方法要自己写
////                UserInfoParam userInfoParam = testClientService.selectUserByPhone(phone);
//                if (userInfoParam == null) {
//                    throw new RuntimeException("用户不存在，请重新登录");
//                }

                // 验证 token
                if (TokenUtils.verify(token)) {
                    return true;
                } else {
                    throw new RuntimeException("token过期或不正确，请重新登录");
                }

            }
        }
        throw new RuntimeException("没有权限注解一律不通过");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {


    }


}
