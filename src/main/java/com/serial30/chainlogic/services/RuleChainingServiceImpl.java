package com.serial30.chainlogic.services;

import com.serial30.chainlogic.exceptions.FactNotInferredException;
import com.serial30.chainlogic.rulebase.DiagnoComBRB;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class RuleChainingServiceImpl implements RuleChainingService {

    @Override
    public String doForwardChaining(Map<String, String> data) throws FactNotInferredException {
        var fact = data.containsKey("afeccion") ?
                getDiagnoComInstance(data).getIllness() : getDiagnoComInstance(data).getCondition();
        if (Objects.isNull(fact)) throw new FactNotInferredException("No se puede inferir un resultado acertado");
        return fact;
    }

    private DiagnoComBRB getDiagnoComInstance(Map<String, String> data) {
        var diagnocom = new DiagnoComBRB();
        diagnocom.insertChoices(data);
        return diagnocom;
    }
}
