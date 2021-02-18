package com.mulheres.mulheres_do_brasil.config.security;

import com.mulheres.mulheres_do_brasil.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(Authentication authentication) {
        User userAthenticated = (User) authentication.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + expiration);
        return Jwts.builder()
                .setIssuer("Login!").setSubject(userAthenticated.getId().toString())
                .setIssuedAt(today).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
    public User getAuthenticatedUser(Authentication authentication){
        User userAthenticated = (User) authentication.getPrincipal();

        return userAthenticated;
    }
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        String userId = claims.getSubject();
        return userId;
    }
}
