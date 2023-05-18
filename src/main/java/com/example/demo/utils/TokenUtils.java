package com.example.demo.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @desc   使用token验证用户是否登录
 * @author zm
 **/
public class TokenUtils {
    //设置过期时间
    private static final long EXPIRE_DATE=1000*60*5; //1分钟
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWf";

    public static String token (String username,String password){

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("password",password).withExpiresAt(date)
                    .sign(algorithm);

        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    public static boolean verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            System.out.println("校验失败");
            return  false;
        }
    }

    /**
     * 生成token
     * @param userId
     * @param sign
     * @return
     */
    public static String getToken(String userId,String sign) {
        return JWT.create()
                //签收者
                .withAudience(userId)
                //主题
                .withSubject("token")
                //2小时候token过期
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                //以password作为token的密钥
                .sign(Algorithm.HMAC256(sign));
    }

}
