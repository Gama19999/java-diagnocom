package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class DigestiveOptions extends GeneralOptions {
    public final OptVariable dolorAbdominal;
    public final OptVariable evacuacionesConstantes;
    public final OptVariable nauseas;
    public final OptVariable acidezEstomacal;
    public final OptVariable vomito;
    public final OptVariable hemorragiaRectal;
    public final OptVariable diarrea;
    public final OptVariable evacuacionesConDolor;
    public final OptVariable dolorPecho;
    private final ArrayList<OptVariable> digestiveOpts;

    public DigestiveOptions() { // not calling super(); due to super-class having an explicit default constructor
        localizacion.setValue(Const.BRB.Facts.LOC_DIGESTIVA);
        dolorAbdominal = new OptVariable(Const.BRB.VarName.dolorAbdominal, "Dolor en el abdomen", Const.BRB.Values.NO);
        evacuacionesConstantes = new OptVariable(Const.BRB.VarName.evacuacionesConstantes, "Evacuaciones constantes", Const.BRB.Values.NO);
        nauseas = new OptVariable(Const.BRB.VarName.nauseas, "Nauseas", Const.BRB.Values.NO);
        acidezEstomacal = new OptVariable(Const.BRB.VarName.acidezEstomacal, "Acidez estomacal", Const.BRB.Values.NO);
        vomito = new OptVariable(Const.BRB.VarName.vomito, "Vomito", Const.BRB.Values.NO);
        hemorragiaRectal = new OptVariable(Const.BRB.VarName.hemorragiaRectal, "Hemorragia rectal", Const.BRB.Values.NO);
        diarrea = new OptVariable(Const.BRB.VarName.diarrea, "Diarrea", Const.BRB.Values.NO);
        evacuacionesConDolor = new OptVariable(Const.BRB.VarName.evacuacionesConDolor, "Evacuaciones con dolor", Const.BRB.Values.NO);
        dolorPecho = new OptVariable(Const.BRB.VarName.dolorPecho, "Dolor en el pecho", Const.BRB.Values.NO);
        this.digestiveOpts = new ArrayList<>(Arrays.asList(
                dolorAbdominal, evacuacionesConstantes, nauseas, acidezEstomacal, vomito,
                hemorragiaRectal, diarrea, evacuacionesConDolor, dolorPecho
        ));
    }

    @Override
    public void matchUserOptions(Map<String, String> data) {
        for (String dataVarName: data.keySet()) {
            digestiveOpts.forEach(opt -> {
                if (opt.getName().equals(dataVarName)) opt.setValue(data.get(dataVarName));
            });
        }
    }
}
