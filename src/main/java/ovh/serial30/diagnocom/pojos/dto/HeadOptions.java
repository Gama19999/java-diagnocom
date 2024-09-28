package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

public class HeadOptions {
    public Option _1 = new Option(Const.BRB.Symptoms.dolorCabeza, "Dolor de cabeza", Const.BRB.NO);
    public Option _2 = new Option(Const.BRB.Symptoms.presionArterialAlta, "Presión arterial alta", Const.BRB.NO);
    public Option _3 = new Option(Const.BRB.Symptoms.temperatura, "Temperatura", Const.BRB.TEMP_INI);
    public Option _4 = new Option(Const.BRB.Symptoms.zumbidoOidos, "Zumbido de oidos", Const.BRB.NO);
    public Option _5 = new Option(Const.BRB.Symptoms.nauseas, "Nauseas", Const.BRB.NO);
    public Option _6 = new Option(Const.BRB.Symptoms.dolorGarganta, "Dolor de garganta", Const.BRB.NO);
    public Option _7 = new Option(Const.BRB.Symptoms.dolorOido, "Dolor de oido", Const.BRB.NO);
}