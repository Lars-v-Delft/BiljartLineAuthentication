package com.BiljartLine.Authentication.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final Key key = new SecretKeySpec("PhnBSsuGwqJxsdqYZTBpt5pC7fQWjB3T".getBytes(), "HS256");

    public String generateToken(UserDetails userDetails){
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2))
                .signWith(key)
                .compact();
    }

    public boolean isJWTValid(String jwt, UserDetails userDetails){
        final String jwtUsername = getSubject(jwt);
        return jwtUsername.equals(userDetails.getUsername()) && !isJWTExpired(jwt);
    }

    public boolean isJWTExpired(String jwt){
        return new Date().after(getExperition(jwt));
    }

    public String getSubject(String jwt){
        Claims allClaims = extractAllClaims(jwt);
        return allClaims.getSubject();
    }

    public Date getExperition(String jwt){
        Claims allClaims = extractAllClaims(jwt);
        return allClaims.getExpiration();
    }

    private Claims extractAllClaims(String jwt){
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
}
