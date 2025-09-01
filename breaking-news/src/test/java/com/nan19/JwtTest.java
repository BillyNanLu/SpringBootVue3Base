package com.nan19;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","billy");
        // 生成jwt令牌
        String token = JWT.create()
                .withClaim("user", claims) // 添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 设置过期时间
                .sign(Algorithm.HMAC256("nan19")); // 制定算法，配置密钥
        System.out.println(token);
    }

    @Test
    public void testParse() {
        // 定义字符串，模拟用户传过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6ImJpbGx5In0sImV4cCI6MTc1Njc2MjcyMX0" +
                ".wIpm2x0X76AKImqvY7iyBLi3HNFbyQCqthm-WxVCf6g";
        DecodedJWT decodeJWT = JWT.require(Algorithm.HMAC256("nan19")).build().verify(token);
        Map<String, Claim> claims = decodeJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
