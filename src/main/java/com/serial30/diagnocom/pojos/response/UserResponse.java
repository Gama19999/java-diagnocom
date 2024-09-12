package com.serial30.diagnocom.pojos.response;

import java.sql.Timestamp;

public record UserResponse(
        String userId,
        String username,
        String email,
        Timestamp lastActivity
) {}
