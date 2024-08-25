package com.serial30.chainlogic.rulebase;

import Rule.BooleanRuleBase;

import java.util.Map;
import static java.util.Map.entry;

public class DiagnoComBRB extends DiagnoComVariableSet {
    // Declaracion BASE DE REGLAS
    private final BooleanRuleBase br;

    // Constructor
    public DiagnoComBRB() {
        br = new BooleanRuleBase("diagnocom");
        starterBR(br); // Inicializa la base de reglas

        // Mapea las variables con su nombre
        variables = Map.ofEntries(
            entry("afeccion", afeccion), entry("enfermedad", enfermedad), entry("afeccionCabeza", afeccionCabeza),
            entry("afeccionRespiratoria", afeccionRespiratoria), entry("afeccionDigestiva", afeccionDigestiva),
            entry("afeccionInterna", afeccionInterna), entry("afeccionUrinaria", afeccionUrinaria),
            entry("afeccionPiel", afeccionPiel), entry("dolorCabeza", dolorCabeza),
            entry("presionArterialAlta", presionArterialAlta), entry("fiebre", fiebre),
            entry("zumbidoOidos", zumbidoOidos), entry("nauseas", nauseas), entry("dolorGarganta", dolorGarganta),
            entry("dolorOido", dolorOido), entry("tos", tos), entry("estornudos", estornudos),
            entry("dolorArticulaciones", dolorArticulaciones), entry("dolorEspalda", dolorEspalda),
            entry("dolorPecho", dolorPecho), entry("escurrimientoNasal", escurrimientoNasal), entry("fatiga", fatiga),
            entry("congestionNasal", congestionNasal), entry("dolorCorporal", dolorCorporal),
            entry("dificultadRespiratoria", dificultadRespiratoria), entry("dolorAbdominal", dolorAbdominal),
            entry("evacuacionesConstantes", evacuacionesConstantes), entry("acidezEstomacal", acidezEstomacal),
            entry("vomito", vomito), entry("hemorragiaRectal", hemorragiaRectal), entry("diarrea", diarrea),
            entry("evacuacionesConDolor", evacuacionesConDolor), entry("dolorAlOrinar", dolorAlOrinar),
            entry("sangradoAlOrinar", sangradoAlOrinar), entry("pielEnrogecida", pielEnrogecida),
            entry("inflamacionZona", inflamacionZona), entry("altaSensibilidadZona", altaSensibilidadZona)
        );
    }

    @Override
    public void insertChoices(Map<String, String> choices) {
        for (String variable : choices.keySet()) {
            variables.get(variable).setValue(choices.get(variable));
        }
    }

    @Override
    public String getCondition() {
        br.forwardChain(); // Realiza el encadenamiento hacia adelante
        nameHecho = afeccion.getValue();
        return nameHecho;
    }

    @Override
    public String getIllness() {
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        return nameHecho;
    }
}
