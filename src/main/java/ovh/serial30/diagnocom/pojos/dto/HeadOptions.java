package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class HeadOptions extends GeneralOptions {
    public final OptVariable dolorCabeza;
    public final OptVariable presionArterialAlta;
    public final OptVariable zumbidoOidos;
    public final OptVariable nauseas;
    public final OptVariable dolorGarganta;
    public final OptVariable dolorOido;
    private final ArrayList<OptVariable> headOpts;

    public HeadOptions() { // not calling super(); due to super-class having an explicit default constructor
        localizacion.setValue(Const.BRB.Facts.LOC_CABEZA);
        dolorCabeza = new OptVariable(Const.BRB.VarName.dolorCabeza, "Dolor de cabeza", Const.BRB.Values.NO);
        presionArterialAlta = new OptVariable(Const.BRB.VarName.presionArterialAlta, "Presión arterial alta", Const.BRB.Values.NO);
        zumbidoOidos = new OptVariable(Const.BRB.VarName.zumbidoOidos, "Zumbido de oidos", Const.BRB.Values.NO);
        nauseas = new OptVariable(Const.BRB.VarName.nauseas, "Nauseas", Const.BRB.Values.NO);
        dolorGarganta = new OptVariable(Const.BRB.VarName.dolorGarganta, "Dolor de garganta", Const.BRB.Values.NO);
        dolorOido = new OptVariable(Const.BRB.VarName.dolorOido, "Dolor de oido", Const.BRB.Values.NO);
        this.headOpts = new ArrayList<>(
                Arrays.asList(dolorCabeza, presionArterialAlta, zumbidoOidos, nauseas, dolorGarganta, dolorOido));
    }

    @Override
    public void matchUserOptions(Map<String, String> data) {
        for (String dataVarName: data.keySet()) {
            headOpts.forEach(opt -> {
                if (opt.getName().equals(dataVarName)) opt.setValue(data.get(dataVarName));
            });
        }
    }
}