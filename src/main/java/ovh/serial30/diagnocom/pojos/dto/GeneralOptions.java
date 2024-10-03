package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

import java.util.Map;

/**
 * Representacion que almacena los datos utilizados por la base de reglas y que se envia como respuesta al cliente
 */
public class GeneralOptions {
    public final OptVariable temperatura;
    public final OptVariable grados;
    public final OptVariable localizacion;
    public final OptVariable enfermedad;

    public GeneralOptions() {
        temperatura = new OptVariable(Const.BRB.Facts.TEMPERATURA, "Temperatura corporal", null);
        grados = new OptVariable(Const.BRB.VarName.grados, "°C", Const.BRB.Values.TEMP_37);
        localizacion = new OptVariable(Const.BRB.Facts.LOCALIZACION, "Localización de la afeccion", null);
        enfermedad = new OptVariable(Const.BRB.Facts.ENFERMEDAD, "Enfermedad inferida", null);
    }

    /**
     * Establece el valor de las variables acorde a los datos provenientes del cliente
     * @param data Datos provenientes del cliente
     */
    public void matchUserOptions(Map<String, String> data) {}
}
