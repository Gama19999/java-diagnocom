package ovh.serial30.diagnocom.pojos.response;

import java.sql.Timestamp;

public record UserResponse(
        String username,
        String email,
        Timestamp lastActivity
) {}
