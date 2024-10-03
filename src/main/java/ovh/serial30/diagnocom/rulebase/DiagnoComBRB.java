package ovh.serial30.diagnocom.rulebase;

import Rule.BooleanRuleBase;
import ovh.serial30.diagnocom.configuration.Const;

import javax.swing.JTextArea;
import java.util.Arrays;
import java.util.Map;

import static java.util.Map.entry;

/**
 * Clase que emula la base de reglas
 */
public class DiagnoComBRB extends DiagnoComVariableSet {
    private final BooleanRuleBase brb; // Declaracion BASE DE REGLAS

    /**
     * Crea la instancia de la base de reglas
     */
    public DiagnoComBRB() {
        brb = new BooleanRuleBase("diagnocom");
        starterBR(brb);

        // Mapea las variables con su nombre
        variables = Map.ofEntries(entry(Const.BRB.VarName.grados, grados),
            entry(Const.BRB.Facts.TEMPERATURA, temperatura), entry(Const.BRB.Facts.LOCALIZACION, localizacion),
            entry(Const.BRB.VarName.locCabeza, locCabeza), entry(Const.BRB.VarName.locRespiratoria, locRespiratoria),
            entry(Const.BRB.VarName.locDigestiva, locDigestiva), entry(Const.BRB.VarName.locInterna, locInterna),
            entry(Const.BRB.VarName.locUrinaria, locUrinaria), entry(Const.BRB.VarName.locCutanea, locCutanea),
            entry(Const.BRB.VarName.dolorCabeza, dolorCabeza), entry(Const.BRB.VarName.presionArterialAlta, presionArterialAlta),
            entry(Const.BRB.VarName.zumbidoOidos, zumbidoOidos), entry(Const.BRB.VarName.nauseas, nauseas),
            entry(Const.BRB.VarName.dolorGarganta, dolorGarganta), entry(Const.BRB.VarName.dolorOido, dolorOido),
            entry(Const.BRB.VarName.tos, tos), entry(Const.BRB.VarName.estornudos, estornudos),
            entry(Const.BRB.VarName.dolorArticulaciones, dolorArticulaciones), entry(Const.BRB.VarName.dolorEspalda, dolorEspalda),
            entry(Const.BRB.VarName.dolorPecho, dolorPecho), entry(Const.BRB.VarName.escurrimientoNasal, escurrimientoNasal),
            entry(Const.BRB.VarName.fatiga, fatiga), entry(Const.BRB.VarName.congestionNasal, congestionNasal),
            entry(Const.BRB.VarName.dolorCorporal, dolorCorporal), entry(Const.BRB.VarName.dificultadRespiratoria, dificultadRespiratoria),
            entry(Const.BRB.VarName.dolorAbdominal, dolorAbdominal), entry(Const.BRB.VarName.evacuacionesConstantes, evacuacionesConstantes),
            entry(Const.BRB.VarName.acidezEstomacal, acidezEstomacal), entry(Const.BRB.VarName.vomito, vomito),
            entry(Const.BRB.VarName.hemorragiaRectal, hemorragiaRectal), entry(Const.BRB.VarName.diarrea, diarrea),
            entry(Const.BRB.VarName.evacuacionesConDolor, evacuacionesConDolor), entry(Const.BRB.VarName.dolorAlOrinar, dolorAlOrinar),
            entry(Const.BRB.VarName.sangradoAlOrinar, sangradoAlOrinar), entry(Const.BRB.VarName.pielEnrogecida, pielEnrogecida),
            entry(Const.BRB.VarName.inflamacionZona, inflamacionZona), entry(Const.BRB.VarName.altaSensibilidadZona, altaSensibilidadZona)
        );
    }

    public String getRules() {
        var temp = new JTextArea();
        brb.displayRules(temp);
        return Arrays.toString(temp.getText()
                .replaceAll("diagnocom Rule Base", "Base de reglas: diagnocom")
                .replaceAll("IF", "SI")
                .replaceAll("AND", "Y")
                .replaceAll("THEN", "ENTONCES")
                .split("R"));
    }

    @Override
    public DiagnoComBRB insertChoices(Map<String, String> choices) {
        brb.reset();
        for (String variable : choices.keySet()) {
            if (variable.equals(Const.BRB.Values.CHAINING)) continue;
            variables.get(variable).setValue(choices.get(variable));
        }
        return this;
    }

    @Override
    public String getTemperatura() {
        brb.forwardChain();
        return temperatura.getValue();
    }

    @Override
    public String getLocalizacion() {
        brb.forwardChain();
        return localizacion.getValue();
    }

    @Override
    public String getEnfermedad() {
        brb.forwardChain();
        return enfermedad.getValue();
    }
}
