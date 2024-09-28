package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

public class UrinaryOptions {
    public Option _1 = new Option(Const.BRB.Symptoms.nauseas, "Nauseas", Const.BRB.NO);
    public Option _2 = new Option(Const.BRB.Symptoms.dolorAlOrinar, "Dolor al orinar", Const.BRB.NO);
    public Option _3 = new Option(Const.BRB.Symptoms.sangradoAlOrinar, "Sangrado al orinar", Const.BRB.NO);
    public Option _4 = new Option(Const.BRB.Symptoms.dolorEspalda, "Dolor de espalda", Const.BRB.NO);
    public Option _5 = new Option(Const.BRB.Symptoms.temperatura, "Temperatura", Const.BRB.TEMP_INI);
}
