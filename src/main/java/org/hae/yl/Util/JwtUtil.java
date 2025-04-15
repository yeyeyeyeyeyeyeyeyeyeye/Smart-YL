package org.hae.yl.Util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtil {
    private static final String SECRET = "my_jwt_secret_key";
    private static final long EXPIRATION = 1000 * 60 * 60 * 24; // 1天

    // 生成 Token
        public static String generateToken(String username ,String password,int role) {
        return Jwts.builder()
            //Header 部分
                .setSubject("admin-test")                                         //主题
                //.setIssuedAt(new Date())                                        //设置JWT 签发时间
                .setHeaderParam("type", "JWT")                              //类型
                .setHeaderParam("algo", "hs256")                            //加密算法
            //Payload 载荷部分
                .claim("username", username)
                //.claim("password", password)
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .setId(UUID.randomUUID().toString())                              //为生成的 JWT 设置一个随机的，唯一的 UUID 字符串（标识符）
            //Signature 签名
                .signWith(SignatureAlgorithm.HS256, SECRET)                       //为生成的 JWT 设置 签名算法 和 签名密钥
                .compact();                                                       //生成并返回最终的 JWT 字符串
    }




    // 解析 Token
    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)                                             //为 JWT 解析过程指定密钥，用于 验证 JWT 的签名 是否有效
                .parseClaimsJws(token)                                             //解析 JWT并提取其中的 Claims
                .getBody().getSubject();                                           //获取 JWT 主题
    }

    // 验证 Token 是否有效
    public static boolean validateToken(String token) {
        try {
            if (token == null){
                return false;
            }
            System.out.println("验证 Token 是否有效 ： "+
                    Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token)
            );
        } catch (Exception e) {
            return false;
        }
            return true;
    }

//    public static String validateTokenAndGetRole(String token) {
//        String  = getUsername(token)
//    }
}