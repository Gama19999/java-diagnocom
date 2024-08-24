package com.serial30.chainlogic.services;

import com.serial30.chainlogic.exceptions.FactNotInferredException;
import com.serial30.chainlogic.rulebase.DiagnoComBR;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class RuleChainingServiceImpl implements RuleChainingService {

    @Override
    public String do1stForwardChaining(ArrayList<Boolean> data) throws FactNotInferredException {
        var choices = new ArrayList<String>();
        data.forEach(i -> choices.add(i ? "SI" : "NO"));
        var fact = new DiagnoComBR().getAfeccion(choices);

        if (Objects.isNull(fact)) throw new FactNotInferredException("No se puede inferir un resultado acertado");
        return fact;
    }
}
