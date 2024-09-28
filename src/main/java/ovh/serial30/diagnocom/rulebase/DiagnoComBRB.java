package ovh.serial30.diagnocom.rulebase;

import Rule.BooleanRuleBase;
import org.springframework.http.HttpStatus;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.exceptions.FactAnalysisException;

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
            entry(Const.BRB.afeccion, afeccion), entry(Const.BRB.Symptoms.afeccionCabeza, afeccionCabeza),
            entry(Const.BRB.Symptoms.afeccionRespiratoria, afeccionRespiratoria), entry(Const.BRB.Symptoms.afeccionDigestiva, afeccionDigestiva),
            entry(Const.BRB.Symptoms.afeccionInterna, afeccionInterna), entry(Const.BRB.Symptoms.afeccionUrinaria, afeccionUrinaria),
            entry(Const.BRB.Symptoms.afeccionPiel, afeccionPiel), entry(Const.BRB.Symptoms.dolorCabeza, dolorCabeza),
            entry(Const.BRB.Symptoms.presionArterialAlta, presionArterialAlta), entry(Const.BRB.Symptoms.temperatura, temperatura),
            entry(Const.BRB.Symptoms.zumbidoOidos, zumbidoOidos), entry(Const.BRB.Symptoms.nauseas, nauseas),
            entry(Const.BRB.Symptoms.dolorGarganta, dolorGarganta), entry(Const.BRB.Symptoms.dolorOido, dolorOido),
            entry(Const.BRB.Symptoms.tos, tos), entry(Const.BRB.Symptoms.estornudos, estornudos),
            entry(Const.BRB.Symptoms.dolorArticulaciones, dolorArticulaciones), entry(Const.BRB.Symptoms.dolorEspalda, dolorEspalda),
            entry(Const.BRB.Symptoms.dolorPecho, dolorPecho), entry(Const.BRB.Symptoms.escurrimientoNasal, escurrimientoNasal),
            entry(Const.BRB.Symptoms.fatiga, fatiga), entry(Const.BRB.Symptoms.congestionNasal, congestionNasal),
            entry(Const.BRB.Symptoms.dolorCorporal, dolorCorporal), entry(Const.BRB.Symptoms.dificultadRespiratoria, dificultadRespiratoria),
            entry(Const.BRB.Symptoms.dolorAbdominal, dolorAbdominal), entry(Const.BRB.Symptoms.evacuacionesConstantes, evacuacionesConstantes),
            entry(Const.BRB.Symptoms.acidezEstomacal, acidezEstomacal), entry(Const.BRB.Symptoms.vomito, vomito),
            entry(Const.BRB.Symptoms.hemorragiaRectal, hemorragiaRectal), entry(Const.BRB.Symptoms.diarrea, diarrea),
            entry(Const.BRB.Symptoms.evacuacionesConDolor, evacuacionesConDolor), entry(Const.BRB.Symptoms.dolorAlOrinar, dolorAlOrinar),
            entry(Const.BRB.Symptoms.sangradoAlOrinar, sangradoAlOrinar), entry(Const.BRB.Symptoms.pielEnrogecida, pielEnrogecida),
            entry(Const.BRB.Symptoms.inflamacionZona, inflamacionZona), entry(Const.BRB.Symptoms.altaSensibilidadZona, altaSensibilidadZona)
        );
    }

    @Override
    public void insertChoices(Map<String, String> choices) throws FactAnalysisException {
        for (String variable : choices.keySet()) {
            if (variable.equals(Const.BRB.Symptoms.temperatura) &&
                Float.parseFloat(choices.get(variable)) < Float.parseFloat(Const.BRB.TEMP_36))
                throw new FactAnalysisException(HttpStatus.INTERNAL_SERVER_ERROR.value(), Const.Logs.VALID_TEMP);
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
