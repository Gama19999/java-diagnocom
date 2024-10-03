package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class InternalOptions extends GeneralOptions {
    public final OptVariable dolorAbdominal;
    public final OptVariable nauseas;
    public final OptVariable vomito;
    public final OptVariable fatiga;
    public final OptVariable dolorPecho;
    public final OptVariable acidezEstomacal;
    public final OptVariable dolorEspalda;
    public final OptVariable evacuacionesConstantes;
    public final OptVariable dolorGarganta;
    public final OptVariable hemorragiaRectal;
    public final OptVariable diarrea;
    private final ArrayList<OptVariable> internalOpts;

    public InternalOptions() { // not calling super(); due to super-class having an explicit default constructor
        localizacion.setValue(Const.BRB.Facts.LOC_INTERNA);
        dolorAbdominal = new OptVariable(Const.BRB.VarName.dolorAbdominal, "Dolor en el abdomen", Const.BRB.Values.NO);
        nauseas = new OptVariable(Const.BRB.VarName.nauseas, "Nauseas", Const.BRB.Values.NO);
        vomito = new OptVariable(Const.BRB.VarName.vomito, "Vomito", Const.BRB.Values.NO);
        fatiga = new OptVariable(Const.BRB.VarName.fatiga, "Fatíga", Const.BRB.Values.NO);
        dolorPecho = new OptVariable(Const.BRB.VarName.dolorPecho, "Dolor en el pecho", Const.BRB.Values.NO);
        acidezEstomacal = new OptVariable(Const.BRB.VarName.acidezEstomacal, "Acidez estomacal", Const.BRB.Values.NO);
        dolorEspalda = new OptVariable(Const.BRB.VarName.dolorEspalda, "Dolor de espalda", Const.BRB.Values.NO);
        evacuacionesConstantes = new OptVariable(Const.BRB.VarName.evacuacionesConstantes, "Evacuaciones constantes", Const.BRB.Values.NO);
        dolorGarganta = new OptVariable(Const.BRB.VarName.dolorGarganta, "Dolor de garganta", Const.BRB.Values.NO);
        hemorragiaRectal = new OptVariable(Const.BRB.VarName.hemorragiaRectal, "Hemorragia rectal", Const.BRB.Values.NO);
        diarrea = new OptVariable(Const.BRB.VarName.diarrea, "Diarrea", Const.BRB.Values.NO);
        internalOpts = new ArrayList<>(Arrays.asList(
                dolorAbdominal, nauseas, vomito, fatiga, dolorPecho, acidezEstomacal, dolorEspalda,
                evacuacionesConstantes, dolorGarganta, hemorragiaRectal, diarrea
        ));
    }

    @Override
    public void matchUserOptions(Map<String, String> data) {
        for (String dataVarName: data.keySet()) {
            internalOpts.forEach(opt -> {
                if (opt.getName().equals(dataVarName)) opt.setValue(data.get(dataVarName));
            });
        }
    }
}