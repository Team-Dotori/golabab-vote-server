package com.dotori.golababvoteserver.global.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.function.Consumer;

public abstract class JwtUtils {
    private Claims getClaimsToToken(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .parseClaimsJws(token)
                .getBody();
    }

    protected String  createToken(String issuer, Map<String, Object> claims, Integer tokenExpiredMinute) {
        Date date = new Date();

        return Jwts.builder()
                .setSubject(issuer)
                .setClaims(claims)
                .setIssuer(issuer)
                .setIssuedAt(date)
                .setExpiration(getExpiration(date, tokenExpiredMinute))
                .signWith(SignatureAlgorithm.HS256, getSigningKey())
                .compact();
    }
    private Date getExpiration(Date issuedAt, Integer tokenExpiredMinute) {
        return new Date(issuedAt.getTime() + Duration.ofMinutes(tokenExpiredMinute).toMillis());
    }

    final protected void doWithClaimsToToken(String token, Consumer<Claims> doWhat) {
        doWhat.accept(getClaimsToToken(token));
    }

    protected abstract String getSigningKey();
}
