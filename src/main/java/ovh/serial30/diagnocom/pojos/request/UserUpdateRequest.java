package ovh.serial30.diagnocom.pojos.request;

/**
 * Representacion de los datos de a modificar del usuario
 * @param username Nombre de usuario
 * @param email Correo electronico del usuario
 * @param currentPassword Password actual del usuario
 * @param newPassword Nuevo password del usuario (opcional)
 */
public record UserUpdateRequest(
        String username,
        String email,
        String currentPassword,
        String newPassword
) {}
