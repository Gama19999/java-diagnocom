package ovh.serial30.diagnocom.pojos.response;

import ovh.serial30.diagnocom.pojos.dto.GeneralOptions;

import java.sql.Timestamp;

/**
 * Representacion de los datos del resultado del diagnostico inferido
 * @param resultId ID del resultado
 * @param username Nombre de usuario que genero el resultado
 * @param content Representacion que almacena los datos utilizados por la base de reglas
 * @param resultDate Fecha en la que se genero el resultado
 */
public record ResultResponse(
        String resultId,
        String username,
        GeneralOptions content,
        Timestamp resultDate
) {}
