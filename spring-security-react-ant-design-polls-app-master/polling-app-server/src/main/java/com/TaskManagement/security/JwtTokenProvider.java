package com.TaskManagement.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.TaskManagement.payload.SignInHelper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.InvalidKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication)  {

        try {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
            SignInHelper helper = new SignInHelper();
            helper.setId(userPrincipal.getId());
            helper.setName(userPrincipal.getName());
            helper.setUsername(userPrincipal.getUsername());
            List<GrantedAuthority> authorities = userPrincipal.getAuthorities();
            helper.setRoleName(authorities.get(0).getAuthority());
            return Jwts.builder()
                   //.setSubject(Long.toString(userPrincipal.getId()))
                    .setSubject(new ObjectMapper().writeValueAsString(helper))
                    .setIssuedAt(new Date())
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        String claim = String.valueOf(claims.getSubject());
        Long id = null;
        try {
            SignInHelper helper = new ObjectMapper().readValue(claim, SignInHelper.class);
            id = helper.getId();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
