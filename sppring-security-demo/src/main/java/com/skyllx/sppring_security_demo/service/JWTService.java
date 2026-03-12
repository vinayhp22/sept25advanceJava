package com.skyllx.sppring_security_demo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JWTService {

    private String secretkey = "siddaramaihisagoodpolitisionandcurrentcmofkarntakasince2023";

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .signWith(Keys.hmacShaKeyFor(secretkey.getBytes()))
                .compact();
    }

    public boolean validateToken(String token){
        Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secretkey.getBytes()))
                .build()
                .parseSignedClaims(token);
        return true;
    }

    public String extractUsername(String token){
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secretkey.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload().getSubject();
    }
}
