package com.goodbuy.googbuylogin.login.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author: feiWoSCun
 * @Time: 2024/11/09
 * @Email: 2825097536@qq.com
 * @description: jwt相关
 */
public class JwtTokenUtil {
    private static final Long EXPIRE_TIME_AFTER = (1000 * 60 * 60 * 4L);
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 续期的阈值时间（例如，剩余30分钟时触发续期）
    private final long RENEW_THRESHOLD = 1000 * 60 * 30;
    // 生成JWT Token
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    // 解析用户名
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 验证Token
    public Boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // 4小时有效期
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME_AFTER))
                .signWith(key)
                .compact();
    }

    /**
     * 续期
     * @param token
     * @return 新 token
     */
    public String renewToken(String token) {
        Date expirationDate = extractExpiration(token);
        long timeRemaining = expirationDate.getTime() - System.currentTimeMillis();

        // 检查是否需要续期
        if (timeRemaining < RENEW_THRESHOLD) {
            String username = extractUsername(token);
            return generateToken(username);
        }
        return token;
    }
}
