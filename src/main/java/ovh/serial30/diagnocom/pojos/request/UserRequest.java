package ovh.serial30.diagnocom.pojos.request;

/**
 * Representacion de los datos de autenticacion del usuario
 * @param username Nombre de usuario
 * @param password Password del usuario
 */
public record UserRequest(
        String username,
        String password
) {}
