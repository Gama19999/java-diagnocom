package ovh.serial30.diagnocom.pojos.response;

import java.sql.Timestamp;

/**
 * Representacion de los datos del usuario
 * @param username Nombre de usuario
 * @param email Correo electronico del usuario
 * @param lastActivity Fecha de ultima actividad en la aplicacion cliente
 */
public record UserResponse(
        String username,
        String email,
        Timestamp lastActivity
) {}
