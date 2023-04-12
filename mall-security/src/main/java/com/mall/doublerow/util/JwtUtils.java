package com.mall.doublerow.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import java.util.Date;

/**
 * @ClassName JwtUtil
 * @Description TODO
 * @Date 2023/4/12 15:11
 * @Version 1.0
 */
public class JwtUtils {
    /**
     * token的失效时间
     */
    private final static long TIME_OUT = 60 * 1000;
    /*
     * 请求头
     * */
    public static final String tokenHeard = "token";
    /**
     * token的密钥
     */
    private static final String KEY = "doublerowmall_java";

    /**
     * 识别token
     * @param token
     * @return
     */
    public static Claims parseJWT(String token) {
        Claims claims = null;
        claims =  Jwts.parser()
//                .setSigningKey(TextCodec.BASE64.encode(KEY))
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    /**
     * 生成token
     * @param id
     * @return
     */
    public static String createToken(String id){
        JwtBuilder builder = Jwts.builder()
                .setSubject(id)
                .signWith(SignatureAlgorithm.HS256, KEY);

        return builder.compact();
    }


}

