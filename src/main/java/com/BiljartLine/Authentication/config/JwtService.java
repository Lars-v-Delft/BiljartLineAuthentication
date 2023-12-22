package com.BiljartLine.Authentication.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final UserDetailsService userDetailsService;
    private final Key key = new SecretKeySpec(System.getenv("KEY").getBytes(), SignatureAlgorithm.HS256.getJcaName());

    public String generateToken(UserDetails userDetails) {
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(key)
                .compact();
    }

    public void validate(String jwt) {
        Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
    }

    public String getSubject(String jwt) {
        Claims allClaims = extractAllClaims(jwt);
        return allClaims.getSubject();
    }

    public Date getExpiration(String jwt) {
        Claims allClaims = extractAllClaims(jwt);
        return allClaims.getExpiration();
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
}
