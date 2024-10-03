package ovh.serial30.diagnocom.pojos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Representacion de los datos entrantes a la API
 */
@Getter @Setter
public class IncomingData {
    /**
     * Mapa que almacena las opciones del usuario
     */
    private Map<String, String> object;
}
