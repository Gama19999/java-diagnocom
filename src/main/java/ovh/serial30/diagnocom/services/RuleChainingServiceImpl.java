package ovh.serial30.diagnocom.services;

import org.springframework.http.HttpStatus;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.exceptions.FactAnalysisException;
import ovh.serial30.diagnocom.pojos.dto.*;
import ovh.serial30.diagnocom.rulebase.DiagnoComBRB;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RuleChainingServiceImpl implements RuleChainingService {

    @Override
    public ArrayList<Object> doForwardChaining(Map<String, String> data) throws FactAnalysisException {
        var is2ndChaining = data.containsKey(Const.BRB.afeccion);
        var fact = is2ndChaining ? getDiagnoComInstance(data).getIllness() : getDiagnoComInstance(data).getCondition();
        if (Objects.isNull(fact)) throw new FactAnalysisException(HttpStatus.NOT_FOUND.value(), Const.Logs.FACT_NOT_INFERRED);
        return buildResponse(is2ndChaining, fact);
    }

    private DiagnoComBRB getDiagnoComInstance(Map<String, String> data) throws FactAnalysisException {
        var diagnocom = new DiagnoComBRB();
        diagnocom.insertChoices(data);
        return diagnocom;
    }

    private ArrayList<Object> buildResponse(boolean is2ndChaining, String fact) {
        var factMap = Collections.singletonMap(is2ndChaining ? Const.BRB.enfermedad : Const.BRB.afeccion, fact);
        Object options = "";
        switch (fact) {
            case Const.BRB.Facts.D_ENCEFALICO -> options = new HeadOptions();
            case Const.BRB.Facts.D_RESPIRATORIO -> options = new RespiratoryOptions();
            case Const.BRB.Facts.D_DIGESTIVO -> options = new DigestiveOptions();
            case Const.BRB.Facts.D_INTERNO -> options = new InternalOptions();
            case Const.BRB.Facts.D_URINARIO -> options = new UrinaryOptions();
            case Const.BRB.Facts.D_CUTANEO -> options = new SkinOptions();
        }
        return new ArrayList<>(Arrays.asList(factMap, options));
    }
}
