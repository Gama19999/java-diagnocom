package ovh.serial30.diagnocom.pojos.dto;

import ovh.serial30.diagnocom.configuration.Const;

public class RespiratoryOptions {
    public Option _1 = new Option(Const.BRB.Symptoms.tos, "Tos", Const.BRB.NO);
    public Option _2 = new Option(Const.BRB.Symptoms.temperatura, "Temperatura", Const.BRB.TEMP_INI);
    public Option _3 = new Option(Const.BRB.Symptoms.dolorGarganta, "Dolor de garganta", Const.BRB.NO);
    public Option _4 = new Option(Const.BRB.Symptoms.dolorPecho, "Dolor en el pecho", Const.BRB.NO);
    public Option _5 = new Option(Const.BRB.Symptoms.escurrimientoNasal, "Escurrimiento nasal", Const.BRB.NO);
    public Option _6 = new Option(Const.BRB.Symptoms.fatiga, "Fatíga", Const.BRB.NO);
    public Option _7 = new Option(Const.BRB.Symptoms.congestionNasal, "Congestion nasal", Const.BRB.NO);
    public Option _8 = new Option(Const.BRB.Symptoms.dolorCabeza, "Dolor de cabeza", Const.BRB.NO);
    public Option _9 = new Option(Const.BRB.Symptoms.dolorCorporal, "Dolor de cuerpo", Const.BRB.NO);
    public Option _10 = new Option(Const.BRB.Symptoms.dificultadRespiratoria, "Dificultad para respirar", Const.BRB.NO);
    public Option _11 = new Option(Const.BRB.Symptoms.estornudos, "Estornudos", Const.BRB.NO);
    public Option _12 = new Option(Const.BRB.Symptoms.dolorArticulaciones, "Dolor en las articulaciones", Const.BRB.NO);
    public Option _13 = new Option(Const.BRB.Symptoms.dolorEspalda, "Dolor de espalda", Const.BRB.NO);
}
