package com.serial30.diagnocom.services;

import com.serial30.diagnocom.exceptions.FactNotInferredException;
import com.serial30.diagnocom.pojos.dto.*;
import com.serial30.diagnocom.rulebase.DiagnoComBRB;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RuleChainingServiceImpl implements RuleChainingService {

    @Override
    public ArrayList<Object> doForwardChaining(Map<String, String> data) throws FactNotInferredException {
        var is2ndChaining = data.containsKey("afeccion");
        var fact = is2ndChaining ? getDiagnoComInstance(data).getIllness() : getDiagnoComInstance(data).getCondition();
        if (Objects.isNull(fact)) throw new FactNotInferredException("No se puede inferir un resultado acertado");
        return buildResponse(is2ndChaining, fact);
    }

    private DiagnoComBRB getDiagnoComInstance(Map<String, String> data) {
        var diagnocom = new DiagnoComBRB();
        diagnocom.insertChoices(data);
        return diagnocom;
    }

    private ArrayList<Object> buildResponse(boolean is2ndChaining, String fact) {
        var factMap = Collections.singletonMap(is2ndChaining ? "enfermedad" : "afeccion", fact);
        Object options = "";
        switch (fact) {
            case "Diagnóstico Encefálico" -> options = new HeadOptions();
            case "Diagnóstico Respiratorio" -> options = new RespiratoryOptions();
            case "Diagnóstico Digestivo" -> options = new DigestiveOptions();
            case "Diagnóstico Interno" -> options = new InternalOptions();
            case "Diagnóstico Urinario" -> options = new UrinaryOptions();
            case "Diagnóstico Cutáneo" -> options = new SkinOptions();
        }
        return new ArrayList<>(Arrays.asList(factMap, options));
    }
}
