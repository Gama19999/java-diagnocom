package com.serial30.diagnocom.services;

import java.util.UUID;

public interface JWTService {

    String generateToken(String userId);

    boolean isValidToken(String token);

    UUID getUserId(String token);
}
