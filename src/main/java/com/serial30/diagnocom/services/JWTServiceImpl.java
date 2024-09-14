package com.serial30.diagnocom.services;

import com.serial30.diagnocom.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {
    private final SecretKey secretKey;

    @Value("${app.name}")
    private String appName;
    @Autowired
    private UserRepository userRepository;

    public JWTServiceImpl() {
        secretKey = Jwts.SIG.HS256.key().build();
    }

    @Override
    public String generateToken(String userId) {
        return Jwts.builder()
                .subject(userId)
                .issuer(appName)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public UUID getUserId(String token) {
        return UUID.fromString(getClaim(token, Claims::getSubject).toString());
    }

    private Object getClaim(String token, Function<Claims, Object> claimResolver) {
        var payload = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
        return claimResolver.apply(payload);
    }

    @Override
    public boolean isValidToken(String token) {
        return userRepository.findById(getUserId(token)).isPresent();
    }
}
