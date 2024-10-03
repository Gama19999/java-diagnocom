package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SkinOptions extends GeneralOptions {
    public final OptVariable pielEnrogecida;
    public final OptVariable inflamacionZona;
    public final OptVariable altaSensibilidadZona;
    private final ArrayList<OptVariable> skinOpts;

    public SkinOptions() { // not calling super(); due to super-class having an explicit default constructor
        localizacion.setValue(Const.BRB.Facts.LOC_CUTANEA);
        pielEnrogecida = new OptVariable(Const.BRB.VarName.pielEnrogecida, "Piel enrogecida", Const.BRB.Values.NO);
        inflamacionZona = new OptVariable(Const.BRB.VarName.inflamacionZona, "Inflamación de la zona", Const.BRB.Values.NO);
        altaSensibilidadZona = new OptVariable(Const.BRB.VarName.altaSensibilidadZona, "Alta sensibilidad en la zona", Const.BRB.Values.NO);
        skinOpts = new ArrayList<>(Arrays.asList(pielEnrogecida, inflamacionZona, altaSensibilidadZona));
    }

    @Override
    public void matchUserOptions(Map<String, String> data) {
        for (String dataVarName: data.keySet()) {
            skinOpts.forEach(opt -> {
                if (opt.getName().equals(dataVarName)) opt.setValue(data.get(dataVarName));
            });
        }
    }
}