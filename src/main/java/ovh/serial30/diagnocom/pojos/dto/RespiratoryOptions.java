package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class RespiratoryOptions extends GeneralOptions {
    public final OptVariable tos;
    public final OptVariable dolorGarganta;
    public final OptVariable dolorPecho;
    public final OptVariable escurrimientoNasal;
    public final OptVariable fatiga;
    public final OptVariable congestionNasal;
    public final OptVariable dolorCabeza;
    public final OptVariable dolorCorporal;
    public final OptVariable dificultadRespiratoria;
    public final OptVariable estornudos;
    public final OptVariable dolorArticulaciones;
    public final OptVariable dolorEspalda;
    private final ArrayList<OptVariable> respiratoryOpts;

    public RespiratoryOptions() { // not calling super(); due to super-class having an explicit default constructor
        localizacion.setValue(Const.BRB.Facts.LOC_RESPIRATORIA);
        tos = new OptVariable(Const.BRB.VarName.tos, "Tos", Const.BRB.Values.NO);
        dolorGarganta = new OptVariable(Const.BRB.VarName.dolorGarganta, "Dolor de garganta", Const.BRB.Values.NO);
        dolorPecho = new OptVariable(Const.BRB.VarName.dolorPecho, "Dolor en el pecho", Const.BRB.Values.NO);
        escurrimientoNasal = new OptVariable(Const.BRB.VarName.escurrimientoNasal, "Escurrimiento nasal", Const.BRB.Values.NO);
        fatiga = new OptVariable(Const.BRB.VarName.fatiga, "Fatíga", Const.BRB.Values.NO);
        congestionNasal = new OptVariable(Const.BRB.VarName.congestionNasal, "Congestion nasal", Const.BRB.Values.NO);
        dolorCabeza = new OptVariable(Const.BRB.VarName.dolorCabeza, "Dolor de cabeza", Const.BRB.Values.NO);
        dolorCorporal = new OptVariable(Const.BRB.VarName.dolorCorporal, "Dolor de cuerpo", Const.BRB.Values.NO);
        dificultadRespiratoria = new OptVariable(Const.BRB.VarName.dificultadRespiratoria, "Dificultad para respirar", Const.BRB.Values.NO);
        estornudos = new OptVariable(Const.BRB.VarName.estornudos, "Estornudos", Const.BRB.Values.NO);
        dolorArticulaciones = new OptVariable(Const.BRB.VarName.dolorArticulaciones, "Dolor en las articulaciones", Const.BRB.Values.NO);
        dolorEspalda = new OptVariable(Const.BRB.VarName.dolorEspalda, "Dolor de espalda", Const.BRB.Values.NO);
        respiratoryOpts = new ArrayList<>(Arrays.asList(
                tos, dolorGarganta, dolorPecho, escurrimientoNasal, fatiga, congestionNasal, dolorCabeza,
                dolorCorporal, dificultadRespiratoria, estornudos, dolorArticulaciones, dolorEspalda
        ));
    }

    @Override
    public void matchUserOptions(Map<String, String> data) {
        for (String dataVarName: data.keySet()) {
            respiratoryOpts.forEach(opt -> {
                if (opt.getName().equals(dataVarName)) opt.setValue(data.get(dataVarName));
            });
        }
    }
}
