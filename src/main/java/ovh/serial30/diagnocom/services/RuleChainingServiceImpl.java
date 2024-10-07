package ovh.serial30.diagnocom.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.exceptions.FactAnalysisException;
import ovh.serial30.diagnocom.exceptions.ServerException;
import ovh.serial30.diagnocom.pojos.dto.*;
import ovh.serial30.diagnocom.rulebase.DiagnoComBRB;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RuleChainingServiceImpl implements RuleChainingService {

    @Autowired
    private ResultService resultService;

    @Override
    public Object doForwardChaining(Map<String, String> data)
            throws FactAnalysisException, JsonProcessingException, ServerException {
        var brb = new DiagnoComBRB();
        var temperatura = brb.insertChoices(data).getTemperatura();
        var grados = data.get(Const.BRB.VarName.grados);
        var localizacion = brb.insertChoices(data).getLocalizacion();
        var enfermedad = brb.insertChoices(data).getEnfermedad();
        var generalOptions = set(temperatura, grados, localizacion, enfermedad);
        if (data.get(Const.BRB.Values.CHAINING).equals(Const.BRB.Values.THIRD) && is3rdChainingValid(generalOptions))
            return resultService.saveResult(generalOptions, data);
        return generalOptions;
    }

    /**
     * Establece los valores de los datos utilizados por la base de reglas
     * @param t Valor del hecho <b>temperatura</b>
     * @param g Valor de la variable <b>grados</b>
     * @param l Valor del hecho <b>localizacion</b>
     * @param e Valor del hecho <b>enfermedad</b>
     * @return Representacion que almacena los datos utilizados por la base de reglas
     */
    private GeneralOptions set(String t, String g, String l, String e) {
        var generalOptions = getOptionsBy(l);
        generalOptions.temperatura.setValue(t);
        generalOptions.grados.setValue(g);
        generalOptions.enfermedad.setValue(e);
        return generalOptions;
    }

    /**
     * Genera la representacion de los datos utilizados por la base de reglas de acuerdo a la localizacion
     * @param localizacion Resultado del 2do encadenamiento
     * @return Representacion que almacena los datos utilizados por la base de reglas
     */
    private GeneralOptions getOptionsBy(String localizacion) {
        GeneralOptions options;
        localizacion = localizacion == null ? "" : localizacion;
        switch (localizacion) {
            case Const.BRB.Facts.LOC_CABEZA -> options = new HeadOptions();
            case Const.BRB.Facts.LOC_RESPIRATORIA -> options = new RespiratoryOptions();
            case Const.BRB.Facts.LOC_DIGESTIVA -> options = new DigestiveOptions();
            case Const.BRB.Facts.LOC_INTERNA -> options = new InternalOptions();
            case Const.BRB.Facts.LOC_URINARIA -> options = new UrinaryOptions();
            case Const.BRB.Facts.LOC_CUTANEA -> options = new SkinOptions();
            default -> options = new LocOptions();
        }
        return options;
    }

    /**
     * Comprueba si el <b>3er</b> encadenamiento es valido
     * @param generalOptions Representacion que almacena los datos utilizados por la base de reglas
     * @return {@code true} si y solo si el <b>3er</b> encadenamiento es valido
     * @throws FactAnalysisException Si no se puede inferir el el resultado del <b>3er</b> encadenamiento
     */
    private boolean is3rdChainingValid(GeneralOptions generalOptions) throws FactAnalysisException {
        if (generalOptions.enfermedad.getValue() == null)
            throw new FactAnalysisException(HttpStatus.NOT_FOUND.value(), Const.Logs.ChainLogic.FACT_NOT_INFERRED);
        return true;
    }
}
