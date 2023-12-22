package com.BiljartLine.Authentication.config;

import com.BiljartLine.Authentication.exceptions.InvalidArgumentException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final Key key = new SecretKeySpec("PhnBSsuGwqJxsdqYZTBpt5pC7fQWjB3T".getBytes(), SignatureAlgorithm.HS256.getJcaName());

    public String generateToken(UserDetails userDetails){
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(key)
                .compact();
    }

    public void validate(String jwt){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
        } catch (Exception e){
            throw new BadCredentialsException("Invalid token");
        }
    }

    public boolean isJWTExpired(String jwt){
        return new Date().after(getExpiration(jwt));
    }

    public String getSubject(String jwt){
        Claims allClaims = extractAllClaims(jwt);
        return allClaims.getSubject();
    }

    public Date getExpiration(String jwt){
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
