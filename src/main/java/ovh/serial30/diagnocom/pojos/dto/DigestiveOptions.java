package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

public class DigestiveOptions {
    public Option _1 = new Option(Const.BRB.Symptoms.temperatura, "Temperatura", Const.BRB.TEMP_INI);
    public Option _2 = new Option(Const.BRB.Symptoms.dolorAbdominal, "Dolor en el abdomen", Const.BRB.NO);
    public Option _3 = new Option(Const.BRB.Symptoms.evacuacionesConstantes, "Evacuaciones constantes", Const.BRB.NO);
    public Option _4 = new Option(Const.BRB.Symptoms.nauseas, "Nauseas", Const.BRB.NO);
    public Option _5 = new Option(Const.BRB.Symptoms.acidezEstomacal, "Acidez estomacal", Const.BRB.NO);
    public Option _6 = new Option(Const.BRB.Symptoms.vomito, "Vomito", Const.BRB.NO);
    public Option _7 = new Option(Const.BRB.Symptoms.fatiga, "Fatíga", Const.BRB.NO);
    public Option _8 = new Option(Const.BRB.Symptoms.hemorragiaRectal, "Hemorragia rectal", Const.BRB.NO);
    public Option _9 = new Option(Const.BRB.Symptoms.diarrea, "Diarrea", Const.BRB.NO);
    public Option _10 = new Option(Const.BRB.Symptoms.evacuacionesConDolor, "Evacuaciones con dolor", Const.BRB.NO);
    public Option _11 = new Option(Const.BRB.Symptoms.dolorPecho, "Dolor en el pecho", Const.BRB.NO);
}
