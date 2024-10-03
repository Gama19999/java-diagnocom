package ovh.serial30.diagnocom.pojos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa una variable de la base de reglas en el lado del cliente
 */
@AllArgsConstructor
@Getter
public class OptVariable {
    private String name;
    private String txt;
    @Setter
    private String value;
}
