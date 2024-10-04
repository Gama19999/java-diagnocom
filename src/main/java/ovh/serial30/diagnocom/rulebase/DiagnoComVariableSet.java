package ovh.serial30.diagnocom.rulebase;

import Rule.*;
import ovh.serial30.diagnocom.configuration.Const;

import java.util.Map;

/**
 * Clase que contiene las variables y declaracion de reglas usadas en los encadenamientos
 */
public abstract class DiagnoComVariableSet {
    // Declaracion variables HECHOS (CONCLUSIONES)
    protected RuleVariable temperatura;
    protected RuleVariable localizacion;
    protected RuleVariable enfermedad;

    // Declaracion variables REGLAS (1-3)
    protected RuleVariable grados;

    // Declaracion variables de REGLAS (4-9)
    protected RuleVariable locCabeza;
    protected RuleVariable locRespiratoria;
    protected RuleVariable locDigestiva;
    protected RuleVariable locInterna;
    protected RuleVariable locUrinaria;
    protected RuleVariable locCutanea;

    // Declaracion variables de REGLAS (10-11)
    protected RuleVariable dolorCabeza;
    protected RuleVariable presionArterialAlta;
    protected RuleVariable zumbidoOidos;
    protected RuleVariable nauseas;
    protected RuleVariable dolorGarganta;
    protected RuleVariable dolorOido;

    // Declaracion variables de REGLAS (12-19)
    protected RuleVariable tos;
    protected RuleVariable dolorPecho;
    protected RuleVariable escurrimientoNasal;
    protected RuleVariable fatiga;
    protected RuleVariable congestionNasal;
    protected RuleVariable dolorCorporal;
    protected RuleVariable dificultadRespiratoria;
    protected RuleVariable estornudos;
    protected RuleVariable dolorArticulaciones;
    protected RuleVariable dolorEspalda;

    // Declaracion variables de REGLAS (20-24)
    protected RuleVariable dolorAbdominal;
    protected RuleVariable evacuacionesConstantes;
    protected RuleVariable acidezEstomacal;
    protected RuleVariable vomito;
    protected RuleVariable hemorragiaRectal;
    protected RuleVariable diarrea;
    protected RuleVariable evacuacionesConDolor;

    // Declaracion variables de REGLAS (29)
    protected RuleVariable dolorAlOrinar;
    protected RuleVariable sangradoAlOrinar;

    // Declaracion variables de REGLAS (30)
    protected RuleVariable pielEnrogecida;
    protected RuleVariable inflamacionZona;
    protected RuleVariable altaSensibilidadZona;

    // Mapa que almacena las variables de la base de reglas
    protected Map<String, RuleVariable> variables;

    /**
     * Establece el valor de las variables en la base de reglas previo a realizar el encadenamiento
     * @param choices Respuestas del usuario
     * @return Instancia de la clase que emula la base de reglas
     */
    public abstract DiagnoComBRB insertChoices(Map<String, String> choices);

    /**
     * Realiza el encadenamiento hacia adelante
     * @return Hecho <b>temperatura</b>
     */
    public abstract String getTemperatura();

    /**
     * Realiza el encadenamiento hacia adelante
     * @return Hecho <b>localizacion</b>
     */
    public abstract String getLocalizacion();

    /**
     * Realiza el encadenamiento hacia adelante
     * @return Hecho <b>enfermedad</b>
     */
    public abstract String getEnfermedad();

    /**
     * Crea las variables y las reglas a usar en los encademanientos
     * @param brb Objeto que almacena la base de reglas
     */
    protected void starterBR(BooleanRuleBase brb) {
        /* Instancias de CONSECUENTES de regla */
        temperatura = new RuleVariable(brb, Const.BRB.Facts.TEMPERATURA);
        localizacion = new RuleVariable(brb, Const.BRB.Facts.LOCALIZACION);
        enfermedad = new RuleVariable(brb, Const.BRB.Facts.ENFERMEDAD);

        /* Instancias de VARIABLES de regla */
        grados = new RuleVariable(brb, Const.BRB.VarName.grados);

        locCabeza = new RuleVariable(brb, Const.BRB.VarName.locCabeza);
        locRespiratoria = new RuleVariable(brb, Const.BRB.VarName.locRespiratoria);
        locDigestiva = new RuleVariable(brb, Const.BRB.VarName.locDigestiva);
        locInterna = new RuleVariable(brb, Const.BRB.VarName.locInterna);
        locUrinaria = new RuleVariable(brb, Const.BRB.VarName.locUrinaria);
        locCutanea = new RuleVariable(brb, Const.BRB.VarName.locCutanea);

        dolorCabeza = new RuleVariable(brb, Const.BRB.VarName.dolorCabeza);
        presionArterialAlta = new RuleVariable(brb, Const.BRB.VarName.presionArterialAlta);
        zumbidoOidos = new RuleVariable(brb, Const.BRB.VarName.zumbidoOidos);
        nauseas = new RuleVariable(brb, Const.BRB.VarName.nauseas);
        dolorGarganta = new RuleVariable(brb, Const.BRB.VarName.dolorGarganta);
        dolorOido = new RuleVariable(brb, Const.BRB.VarName.dolorOido);

        tos = new RuleVariable(brb, Const.BRB.VarName.tos);
        dolorPecho = new RuleVariable(brb, Const.BRB.VarName.dolorPecho);
        escurrimientoNasal = new RuleVariable(brb, Const.BRB.VarName.escurrimientoNasal);
        fatiga = new RuleVariable(brb, Const.BRB.VarName.fatiga);
        congestionNasal = new RuleVariable(brb, Const.BRB.VarName.congestionNasal);
        dolorCorporal = new RuleVariable(brb, Const.BRB.VarName.dolorCorporal);
        dificultadRespiratoria = new RuleVariable(brb, Const.BRB.VarName.dificultadRespiratoria);
        estornudos = new RuleVariable(brb, Const.BRB.VarName.estornudos);
        dolorArticulaciones = new RuleVariable(brb, Const.BRB.VarName.dolorArticulaciones);
        dolorEspalda = new RuleVariable(brb, Const.BRB.VarName.dolorEspalda);

        dolorAbdominal = new RuleVariable(brb, Const.BRB.VarName.dolorAbdominal);
        evacuacionesConstantes = new RuleVariable(brb, Const.BRB.VarName.evacuacionesConstantes);
        acidezEstomacal = new RuleVariable(brb, Const.BRB.VarName.acidezEstomacal);
        vomito = new RuleVariable(brb, Const.BRB.VarName.vomito);
        hemorragiaRectal = new RuleVariable(brb, Const.BRB.VarName.hemorragiaRectal);
        diarrea = new RuleVariable(brb, Const.BRB.VarName.diarrea);
        evacuacionesConDolor = new RuleVariable(brb, Const.BRB.VarName.evacuacionesConDolor);

        dolorAlOrinar = new RuleVariable(brb, Const.BRB.VarName.dolorAlOrinar);
        sangradoAlOrinar = new RuleVariable(brb, Const.BRB.VarName.sangradoAlOrinar);

        pielEnrogecida = new RuleVariable(brb, Const.BRB.VarName.pielEnrogecida);
        inflamacionZona = new RuleVariable(brb, Const.BRB.VarName.inflamacionZona);
        altaSensibilidadZona = new RuleVariable(brb, Const.BRB.VarName.altaSensibilidadZona);

        /* Definicion de operadores logicos (condicionales) */
        var equal = new Condition("=");
        var greater = new Condition(">");
        var less = new Condition("<");

        /* Creacion de reglas de validacion (Base de Reglas) */
        // TEMPERATURA (1-3)
        Rule hipotermia = new Rule(brb, Const.BRB.RuleId.R1,
                new Clause[]{new Clause(grados, less, Const.BRB.Values.TEMP_36)},
                new Clause(temperatura, equal, Const.BRB.Facts.HIPOTERMIA));
        Rule normal = new Rule(brb, Const.BRB.RuleId.R2,
                new Clause[]{new Clause(grados, greater, Const.BRB.Values.TEMP_35_9),
                        new Clause(grados, less, Const.BRB.Values.TEMP_37_6)},
                new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL));
        Rule fiebre = new Rule(brb, Const.BRB.RuleId.R3,
                new Clause[]{new Clause(grados, greater, Const.BRB.Values.TEMP_37_5)},
                new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE));

        // LOCALIZACION (4-9)
        Rule lCabeza = new Rule(brb, Const.BRB.RuleId.R4,
                new Clause[]{new Clause(locCabeza, equal, Const.BRB.Values.SI),
                        new Clause(locRespiratoria, equal, Const.BRB.Values.NO),
                        new Clause(locDigestiva, equal, Const.BRB.Values.NO),
                        new Clause(locInterna, equal, Const.BRB.Values.NO),
                        new Clause(locUrinaria, equal, Const.BRB.Values.NO),
                        new Clause(locCutanea, equal, Const.BRB.Values.NO)},
                new Clause(localizacion, equal, Const.BRB.Facts.LOC_CABEZA));
        Rule lRespiratoria = new Rule(brb, Const.BRB.RuleId.R5,
                new Clause[]{new Clause(locCabeza, equal, Const.BRB.Values.NO),
                        new Clause(locRespiratoria, equal, Const.BRB.Values.SI),
                        new Clause(locDigestiva, equal, Const.BRB.Values.NO),
                        new Clause(locInterna, equal, Const.BRB.Values.NO),
                        new Clause(locUrinaria, equal, Const.BRB.Values.NO),
                        new Clause(locCutanea, equal, Const.BRB.Values.NO)},
                new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA));
        Rule lDigestiva = new Rule(brb, Const.BRB.RuleId.R6,
                new Clause[]{new Clause(locCabeza, equal, Const.BRB.Values.NO),
                        new Clause(locRespiratoria, equal, Const.BRB.Values.NO),
                        new Clause(locDigestiva, equal, Const.BRB.Values.SI),
                        new Clause(locInterna, equal, Const.BRB.Values.NO),
                        new Clause(locUrinaria, equal, Const.BRB.Values.NO),
                        new Clause(locCutanea, equal, Const.BRB.Values.NO)},
                new Clause(localizacion, equal, Const.BRB.Facts.LOC_DIGESTIVA));
        Rule lInterna = new Rule(brb, Const.BRB.RuleId.R7,
                new Clause[]{new Clause(locCabeza, equal, Const.BRB.Values.NO),
                        new Clause(locRespiratoria, equal, Const.BRB.Values.NO),
                        new Clause(locDigestiva, equal, Const.BRB.Values.NO),
                        new Clause(locInterna, equal, Const.BRB.Values.SI),
                        new Clause(locUrinaria, equal, Const.BRB.Values.NO),
                        new Clause(locCutanea, equal, Const.BRB.Values.NO)},
                new Clause(localizacion, equal, Const.BRB.Facts.LOC_INTERNA));
        Rule lUrinaria= new Rule(brb, Const.BRB.RuleId.R8,
                new Clause[]{new Clause(locCabeza, equal, Const.BRB.Values.NO),
                        new Clause(locRespiratoria, equal, Const.BRB.Values.NO),
                        new Clause(locDigestiva, equal, Const.BRB.Values.NO),
                        new Clause(locInterna, equal, Const.BRB.Values.NO),
                        new Clause(locUrinaria, equal, Const.BRB.Values.SI),
                        new Clause(locCutanea, equal, Const.BRB.Values.NO)},
                new Clause(localizacion, equal, Const.BRB.Facts.LOC_URINARIA));
        Rule lCutanea = new Rule(brb, Const.BRB.RuleId.R9,
                new Clause[]{new Clause(locCabeza, equal, Const.BRB.Values.NO),
                        new Clause(locRespiratoria, equal, Const.BRB.Values.NO),
                        new Clause(locDigestiva, equal, Const.BRB.Values.NO),
                        new Clause(locInterna, equal, Const.BRB.Values.NO),
                        new Clause(locUrinaria, equal, Const.BRB.Values.NO),
                        new Clause(locCutanea, equal, Const.BRB.Values.SI)},
                new Clause(localizacion, equal, Const.BRB.Facts.LOC_CUTANEA));

        // ENFERMEDAD CON LOC_CABEZA (10-11)
        Rule migrania = new Rule(brb, Const.BRB.RuleId.R10,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_CABEZA),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.SI),
                        new Clause(presionArterialAlta, equal, Const.BRB.Values.SI),
                        new Clause(zumbidoOidos, equal, Const.BRB.Values.SI),
                        new Clause(nauseas, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.NO),
                        new Clause(dolorOido, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.MIGRANIA));
        Rule infeccionOido = new Rule(brb, Const.BRB.RuleId.R11,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_CABEZA),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.NO),
                        new Clause(presionArterialAlta, equal, Const.BRB.Values.NO),
                        new Clause(zumbidoOidos, equal, Const.BRB.Values.SI),
                        new Clause(nauseas, equal, Const.BRB.Values.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.SI),
                        new Clause(dolorOido, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INF_OIDO));

        // ENFERMEDAD CON LOC_RESPIRATORIA (12-19)
        Rule gripeComun = new Rule(brb, Const.BRB.RuleId.R12,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA),
                        new Clause(tos, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.SI),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.SI),
                        new Clause(congestionNasal, equal, Const.BRB.Values.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.Values.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.Values.NO),
                        new Clause(estornudos, equal, Const.BRB.Values.SI),
                        new Clause(dolorArticulaciones, equal, Const.BRB.Values.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.GRIPE_COMUN));
        Rule bronquitis = new Rule(brb, Const.BRB.RuleId.R13,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA),
                        new Clause(tos, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.SI),
                        new Clause(dolorPecho, equal, Const.BRB.Values.SI),
                        new Clause(escurrimientoNasal, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.SI),
                        new Clause(congestionNasal, equal, Const.BRB.Values.NO),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.NO),
                        new Clause(dolorCorporal, equal, Const.BRB.Values.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.Values.SI),
                        new Clause(estornudos, equal, Const.BRB.Values.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.Values.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.BRONQUITIS));
        Rule sinusitis = new Rule(brb, Const.BRB.RuleId.R14,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA),
                        new Clause(tos, equal, Const.BRB.Values.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.SI),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.NO),
                        new Clause(congestionNasal, equal, Const.BRB.Values.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.Values.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.Values.NO),
                        new Clause(estornudos, equal, Const.BRB.Values.SI),
                        new Clause(dolorArticulaciones, equal, Const.BRB.Values.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.SINUSITIS));
        Rule influenza = new Rule(brb, Const.BRB.RuleId.R15,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA),
                        new Clause(tos, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.SI),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.SI),
                        new Clause(congestionNasal, equal, Const.BRB.Values.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.Values.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.Values.SI),
                        new Clause(estornudos, equal, Const.BRB.Values.SI),
                        new Clause(dolorArticulaciones, equal, Const.BRB.Values.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INFLUENZA));
        Rule sinusitisBacteriana = new Rule(brb, Const.BRB.RuleId.R16,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA),
                        new Clause(tos, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.SI),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.NO),
                        new Clause(congestionNasal, equal, Const.BRB.Values.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.Values.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.Values.NO),
                        new Clause(estornudos, equal, Const.BRB.Values.SI),
                        new Clause(dolorArticulaciones, equal, Const.BRB.Values.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.SINUSITIS_BAC));
        Rule neumonia = new Rule(brb, Const.BRB.RuleId.R17,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA),
                        new Clause(tos, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.Values.NO),
                        new Clause(fatiga, equal, Const.BRB.Values.SI),
                        new Clause(congestionNasal, equal, Const.BRB.Values.NO),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.Values.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.Values.SI),
                        new Clause(estornudos, equal, Const.BRB.Values.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.Values.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.NEUMONIA));
        Rule fibrosisPulmonar = new Rule(brb, Const.BRB.RuleId.R18,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA),
                        new Clause(tos, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.Values.NO),
                        new Clause(fatiga, equal, Const.BRB.Values.SI),
                        new Clause(congestionNasal, equal, Const.BRB.Values.NO),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.NO),
                        new Clause(dolorCorporal, equal, Const.BRB.Values.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.Values.SI),
                        new Clause(estornudos, equal, Const.BRB.Values.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.Values.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.FIBROSIS_PUL));
        Rule bronquiolitis = new Rule(brb, Const.BRB.RuleId.R19,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_RESPIRATORIA),
                        new Clause(tos, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.Values.NO),
                        new Clause(fatiga, equal, Const.BRB.Values.NO),
                        new Clause(congestionNasal, equal, Const.BRB.Values.NO),
                        new Clause(dolorCabeza, equal, Const.BRB.Values.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.Values.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.Values.SI),
                        new Clause(estornudos, equal, Const.BRB.Values.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.Values.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.BRONQUIOLOTIS));

        // ENFERMEDAD CON LOC_DIGESTIVA (20-24)
        Rule infeccionEstomacal = new Rule(brb, Const.BRB.RuleId.R20,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_DIGESTIVA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.SI),
                        new Clause(nauseas, equal, Const.BRB.Values.SI),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.NO),
                        new Clause(vomito, equal, Const.BRB.Values.SI),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.NO),
                        new Clause(diarrea, equal, Const.BRB.Values.SI),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INF_ESTOMACAL));
        Rule estrenimiento = new Rule(brb, Const.BRB.RuleId.R21,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_DIGESTIVA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.NO),
                        new Clause(nauseas, equal, Const.BRB.Values.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.NO),
                        new Clause(vomito, equal, Const.BRB.Values.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.NO),
                        new Clause(diarrea, equal, Const.BRB.Values.NO),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.Values.SI),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.ESTRENIMIENTO));
        Rule indigestion = new Rule(brb, Const.BRB.RuleId.R22,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_DIGESTIVA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.NO),
                        new Clause(nauseas, equal, Const.BRB.Values.SI),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.SI),
                        new Clause(vomito, equal, Const.BRB.Values.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.NO),
                        new Clause(diarrea, equal, Const.BRB.Values.NO),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INDIGESTION));
        Rule gastritis = new Rule(brb, Const.BRB.RuleId.R23,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_DIGESTIVA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.NO),
                        new Clause(nauseas, equal, Const.BRB.Values.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.SI),
                        new Clause(vomito, equal, Const.BRB.Values.SI),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.SI),
                        new Clause(diarrea, equal, Const.BRB.Values.NO),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.Values.SI),
                        new Clause(dolorPecho, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.GASTRITIS));
        Rule colitis = new Rule(brb, Const.BRB.RuleId.R24,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_DIGESTIVA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.NO),
                        new Clause(nauseas, equal, Const.BRB.Values.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.NO),
                        new Clause(vomito, equal, Const.BRB.Values.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.SI),
                        new Clause(diarrea, equal, Const.BRB.Values.SI),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.COLITIS));

        // ENFERMEDAD CON LOC_INTERNA (25-28)
        Rule apendicitis = new Rule(brb, Const.BRB.RuleId.R25,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_INTERNA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.SI),
                        new Clause(nauseas, equal, Const.BRB.Values.SI),
                        new Clause(vomito, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.NO),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.NO),
                        new Clause(diarrea, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.APENDICITIS));
        Rule esofagitis = new Rule(brb, Const.BRB.RuleId.R26,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_INTERNA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.SI),
                        new Clause(nauseas, equal, Const.BRB.Values.SI),
                        new Clause(vomito, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.SI),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.NO),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.SI),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.NO),
                        new Clause(diarrea, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.ESOFAGITIS));
        Rule pancreatitis = new Rule(brb, Const.BRB.RuleId.R27,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_INTERNA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.SI),
                        new Clause(nauseas, equal, Const.BRB.Values.SI),
                        new Clause(vomito, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.NO),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.SI),
                        new Clause(diarrea, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.PANCREATITIS));
        Rule anemia = new Rule(brb, Const.BRB.RuleId.R28,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_INTERNA),
                        new Clause(dolorAbdominal, equal, Const.BRB.Values.NO),
                        new Clause(nauseas, equal, Const.BRB.Values.NO),
                        new Clause(vomito, equal, Const.BRB.Values.SI),
                        new Clause(fatiga, equal, Const.BRB.Values.SI),
                        new Clause(dolorPecho, equal, Const.BRB.Values.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.Values.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.NO),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.Values.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.Values.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.Values.NO),
                        new Clause(diarrea, equal, Const.BRB.Values.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.ANEMIA));

        // ENFERMEDAD CON LOC_URINARIA (29)
        Rule infeccionUrinaria = new Rule(brb, Const.BRB.RuleId.R29,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.FIEBRE),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_URINARIA),
                        new Clause(nauseas, equal, Const.BRB.Values.SI),
                        new Clause(dolorAlOrinar, equal, Const.BRB.Values.SI),
                        new Clause(sangradoAlOrinar, equal, Const.BRB.Values.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INF_URINARIA));

        // ENFERMEDAD CON LOC_CUTANEA (30)
        Rule infeccionPiel = new Rule(brb, Const.BRB.RuleId.R30,
                new Clause[]{new Clause(temperatura, equal, Const.BRB.Facts.TEMP_NORMAL),
                        new Clause(localizacion, equal, Const.BRB.Facts.LOC_CUTANEA),
                        new Clause(pielEnrogecida, equal, Const.BRB.Values.SI),
                        new Clause(inflamacionZona, equal, Const.BRB.Values.SI),
                        new Clause(altaSensibilidadZona, equal, Const.BRB.Values.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INF_PIEL));
    }
}
