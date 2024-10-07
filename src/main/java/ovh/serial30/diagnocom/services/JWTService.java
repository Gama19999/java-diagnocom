package ovh.serial30.diagnocom.services;

import java.util.UUID;

public interface JWTService {
    /**
     * Genera un token para autorizacion del cliente de la API
     * @param userId ID del usuario para generar el token
     * @return Token de usuario
     */
    String generateToken(String userId);

    /**
     * Comprueba la validez del token que envia el cliente
     * @param token Token de usuario
     * @return {@code true} si el token es valido<br>{@code false} de otro modo
     */
    boolean isValidToken(String token);

    /**
     * Obtiene el ID del usuario que hace la solicitud a la API
     * @return ID de usuario del token
     */
    UUID getUserId();

    /**
     * Obtiene el ID del usuario derivado del token enviado por el cliente
     * @param token Token de usuario
     * @return ID de usuario del token
     */
    UUID getUserId(String token);
}
