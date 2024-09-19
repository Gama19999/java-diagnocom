package com.serial30.diagnocom.pojos.request;

public record UserUpdateRequest(
        String username,
        String email,
        String currentPassword,
        String newPassword
) {}
