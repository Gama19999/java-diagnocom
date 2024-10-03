package ovh.serial30.diagnocom.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ovh.serial30.diagnocom.exceptions.FactAnalysisException;
import ovh.serial30.diagnocom.pojos.dto.GeneralOptions;

import java.util.Map;

public interface RuleChainingService {
    /**
     * Obtiene la respuesta del encadenamiento de acuerdo a los datos provenientes del cliente
     * @param data Datos provenientes del cliente
     * @return Respuesta del encadenamiento
     * @throws FactAnalysisException Si no se puede inferir el resultado del encadenamiento dados los antecedentes
     * @throws JsonProcessingException Si hay error al crear el objeto JSON
     */
    GeneralOptions doForwardChaining(Map<String, String> data) throws FactAnalysisException, JsonProcessingException;
}
