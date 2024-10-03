package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class UrinaryOptions extends GeneralOptions {
    public final OptVariable nauseas;
    public final OptVariable dolorAlOrinar;
    public final OptVariable sangradoAlOrinar;
    public final OptVariable dolorEspalda;
    private final ArrayList<OptVariable> urinaryOpts;

    public UrinaryOptions() { // not calling super(); due to super-class having an explicit default constructor
        localizacion.setValue(Const.BRB.Facts.LOC_URINARIA);
        nauseas = new OptVariable(Const.BRB.VarName.nauseas, "Nauseas", Const.BRB.Values.NO);
        dolorAlOrinar = new OptVariable(Const.BRB.VarName.dolorAlOrinar, "Dolor al orinar", Const.BRB.Values.NO);
        sangradoAlOrinar = new OptVariable(Const.BRB.VarName.sangradoAlOrinar, "Sangrado al orinar", Const.BRB.Values.NO);
        dolorEspalda = new OptVariable(Const.BRB.VarName.dolorEspalda, "Dolor de espalda", Const.BRB.Values.NO);
        urinaryOpts = new ArrayList<>(Arrays.asList(nauseas, dolorAlOrinar, sangradoAlOrinar, dolorEspalda));
    }

    @Override
    public void matchUserOptions(Map<String, String> data) {
        for (String dataVarName: data.keySet()) {
            urinaryOpts.forEach(opt -> {
                if (opt.getName().equals(dataVarName)) opt.setValue(data.get(dataVarName));
            });
        }
    }
}
