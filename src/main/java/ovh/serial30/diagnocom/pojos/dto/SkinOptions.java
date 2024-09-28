package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

public class SkinOptions {
    public Option _1 = new Option(Const.BRB.Symptoms.pielEnrogecida, "Piel enrogecida", Const.BRB.NO);
    public Option _2 = new Option(Const.BRB.Symptoms.inflamacionZona, "Inflamación de la zona", Const.BRB.NO);
    public Option _3 = new Option(Const.BRB.Symptoms.altaSensibilidadZona, "Alta sensibilidad en la zona", Const.BRB.NO);
    public Option _4 = new Option(Const.BRB.Symptoms.temperatura, "Temperatura", Const.BRB.TEMP_INI);
}