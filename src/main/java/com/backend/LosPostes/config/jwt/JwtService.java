package com.backend.LosPostes.config.jwt;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtService {
    private final JwtProperties jwtProperties;
    private Key signingKey;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecretKey());
        this.signingKey = Keys.hmacShaKeyFor(keyBytes);
        log.info("Token expiration: {} ms", jwtProperties.getExpiration());
        log.info("Refresh token expiration: {} ms", jwtProperties.getRefreshExpiration());
    }

    public String generaToken(UserDetails userDetails) {
        log.debug("Generando access token con expiración: {} ms", jwtProperties.getExpiration());
        return buildToken(new HashMap<>(), userDetails, jwtProperties.getExpiration());
    }

    public String generaRefreshToken(UserDetails userDetails) {
        log.debug("Generando refresh token con expiración: {} ms", jwtProperties.getRefreshExpiration());
        return buildToken(new HashMap<>(), userDetails, jwtProperties.getRefreshExpiration());
    }

    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expiration);
        
        log.debug("Construyendo token - Fecha actual: {}, Fecha expiración: {}", now, expirationDate);
        
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            final String username = getUserName(token);
            return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
        } catch (Exception e) {
            log.error("Error validando token: ", e);
            return false;
        }
    }

    public String getUserName(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }
}
