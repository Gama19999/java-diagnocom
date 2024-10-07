package ovh.serial30.diagnocom.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ovh.serial30.diagnocom.exceptions.ServerException;
import ovh.serial30.diagnocom.pojos.dto.GeneralOptions;
import ovh.serial30.diagnocom.pojos.response.ResultResponse;

import java.util.List;
import java.util.Map;

public interface ResultService {
    /**
     * Obtienene los datos solicitados del resultado del diagnostico
     * @param resultId ID del resultado solicitado
     * @return Representacion de los datos del resultado del diagnostico
     * @throws ServerException Si el ID de resultado es erroneo
     * @throws JsonProcessingException Si sucede algun error al leer el objeto JSON
     */
    ResultResponse getResult(String resultId) throws ServerException, JsonProcessingException;

    /**
     * Obtienene todos los resultados de diagnostico del usuario que hace la solicitud a la API
     * @return Lista con el grupo de representaciones de los datos de los resultado del diagnostico
     * @throws ServerException Si el usuario que hace la solicitud no cuenta con resultados guardados
     * @throws JsonProcessingException Si sucede algun error al leer el objeto JSON
     */
    List<ResultResponse> getAllResults() throws ServerException, JsonProcessingException;

    /**
     * Guarda el conocimiento inferido en la base de datos
     * @param generalOptions Representacion que almacena los datos utilizados por la base de reglas
     * @param data Datos provenientes del cliente
     * @return Representacion de los datos del resultado del diagnostico
     * @throws JsonProcessingException Si hay error al crear el objeto JSON
     */
    ResultResponse saveResult(GeneralOptions generalOptions, Map<String, String> data) throws JsonProcessingException, ServerException;
}
