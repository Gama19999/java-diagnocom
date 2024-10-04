package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class LocOptions extends GeneralOptions {
    public final OptVariable locCabeza;
    public final OptVariable locRespiratoria;
    public final OptVariable locDigestiva;
    public final OptVariable locInterna;
    public final OptVariable locUrinaria;
    public final OptVariable locCutanea;
    private final ArrayList<OptVariable> locOpts;

    public LocOptions() { // not calling super(); due to super-class having an explicit default constructor
        locCabeza = new OptVariable(Const.BRB.VarName.locCabeza, "En la cabeza", Const.BRB.Values.NO);
        locRespiratoria = new OptVariable(Const.BRB.VarName.locRespiratoria, "Al respirar", Const.BRB.Values.NO);
        locDigestiva = new OptVariable(Const.BRB.VarName.locCabeza, "Tras comer o ir al sanitario", Const.BRB.Values.NO);
        locInterna = new OptVariable(Const.BRB.VarName.locCabeza, "En el abdomen o espalda", Const.BRB.Values.NO);
        locUrinaria = new OptVariable(Const.BRB.VarName.locCabeza, "Al orinar", Const.BRB.Values.NO);
        locCutanea = new OptVariable(Const.BRB.VarName.locCabeza, "En la piel", Const.BRB.Values.NO);
        locOpts = new ArrayList<>(Arrays.asList(
                locCabeza, locRespiratoria, locDigestiva, locInterna, locUrinaria, locCutanea
        ));
    }

    @Override
    public void matchUserOptions(Map<String, String> data) {
        for (String dataVarName: data.keySet()) {
            locOpts.forEach(opt -> {
                if (opt.getName().equals(dataVarName)) opt.setValue(data.get(dataVarName));
            });
        }
    }
}
