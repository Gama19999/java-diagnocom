package ovh.serial30.diagnocom.rulebase;

import Rule.Condition;
import Rule.Rule;
import Rule.RuleVariable;
import Rule.BooleanRuleBase;
import Rule.Clause;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.exceptions.FactAnalysisException;

import java.util.Map;

public abstract class DiagnoComVariableSet {
    // Declaracion variables HECHOS (CONCLUSIONES)
    protected RuleVariable afeccion;
    protected RuleVariable enfermedad;
    protected String nameHecho;

    // Declaracion variables de REGLAS (1-6)
    protected RuleVariable afeccionCabeza;
    protected RuleVariable afeccionRespiratoria;
    protected RuleVariable afeccionDigestiva;
    protected RuleVariable afeccionInterna;
    protected RuleVariable afeccionUrinaria;
    protected RuleVariable afeccionPiel;

    // Declaracion variables de REGLAS (7-8)
    protected RuleVariable dolorCabeza;
    protected RuleVariable presionArterialAlta;
    protected RuleVariable temperatura;
    protected RuleVariable zumbidoOidos;
    protected RuleVariable nauseas;
    protected RuleVariable dolorGarganta;
    protected RuleVariable dolorOido;

    // Declaracion variables de REGLAS (9-17)
    protected RuleVariable tos;
    protected RuleVariable estornudos;
    protected RuleVariable dolorArticulaciones;
    protected RuleVariable dolorEspalda;
    protected RuleVariable dolorPecho;
    protected RuleVariable escurrimientoNasal;
    protected RuleVariable fatiga;
    protected RuleVariable congestionNasal;
    protected RuleVariable dolorCorporal;
    protected RuleVariable dificultadRespiratoria;

    // Declaracion variables de REGLAS (18-22)
    protected RuleVariable dolorAbdominal;
    protected RuleVariable evacuacionesConstantes;
    protected RuleVariable acidezEstomacal;
    protected RuleVariable vomito;
    protected RuleVariable hemorragiaRectal;
    protected RuleVariable diarrea;
    protected RuleVariable evacuacionesConDolor;

    // Declaracion variables de REGLAS (23-26)

    // Declaracion variables de REGLAS (27)
    protected RuleVariable dolorAlOrinar;
    protected RuleVariable sangradoAlOrinar;

    // Declaracion variables de REGLAS (28)
    protected RuleVariable pielEnrogecida;
    protected RuleVariable inflamacionZona;
    protected RuleVariable altaSensibilidadZona;

    // Mapa con las variables
    protected Map<String, RuleVariable> variables;

    // Establece el valor de las variables, obtenidos de un parametro en el metodo
    public abstract void insertChoices(Map<String, String> choices) throws FactAnalysisException;

    // Realiza el encadenamiento hacia adelante y retorna el hecho resultante
    public abstract String getCondition();

    // Realiza el encadenamiento hacia adelante y retorna el hecho resultante
    public abstract String getIllness();

    /**
     * Inicializa los atributos de la clase
     */
    protected void starterBR(BooleanRuleBase br) {
        // Instancias de VARIABLES de regla
        afeccionCabeza = new RuleVariable(br, Const.BRB.Symptoms.afeccionCabeza);
        afeccionRespiratoria = new RuleVariable(br, Const.BRB.Symptoms.afeccionRespiratoria);
        afeccionDigestiva = new RuleVariable(br, Const.BRB.Symptoms.afeccionDigestiva);
        afeccionInterna = new RuleVariable(br, Const.BRB.Symptoms.afeccionInterna);
        afeccionUrinaria = new RuleVariable(br, Const.BRB.Symptoms.afeccionUrinaria);
        afeccionPiel = new RuleVariable(br, Const.BRB.Symptoms.afeccionPiel);

        dolorCabeza = new RuleVariable(br, Const.BRB.Symptoms.dolorCabeza);
        presionArterialAlta = new RuleVariable(br, Const.BRB.Symptoms.presionArterialAlta);
        temperatura = new RuleVariable(br, Const.BRB.Symptoms.temperatura);
        zumbidoOidos = new RuleVariable(br, Const.BRB.Symptoms.zumbidoOidos);
        nauseas = new RuleVariable(br, Const.BRB.Symptoms.nauseas);
        dolorGarganta = new RuleVariable(br, Const.BRB.Symptoms.dolorGarganta);
        dolorOido = new RuleVariable(br, Const.BRB.Symptoms.dolorOido);

        tos = new RuleVariable(br, Const.BRB.Symptoms.tos);
        estornudos = new RuleVariable(br, Const.BRB.Symptoms.estornudos);
        dolorArticulaciones = new RuleVariable(br, Const.BRB.Symptoms.dolorArticulaciones);
        dolorEspalda = new RuleVariable(br, Const.BRB.Symptoms.dolorEspalda);
        dolorPecho = new RuleVariable(br, Const.BRB.Symptoms.dolorPecho);
        escurrimientoNasal = new RuleVariable(br, Const.BRB.Symptoms.escurrimientoNasal);
        fatiga = new RuleVariable(br, Const.BRB.Symptoms.fatiga);
        congestionNasal = new RuleVariable(br, Const.BRB.Symptoms.congestionNasal);
        dolorCorporal = new RuleVariable(br, Const.BRB.Symptoms.dolorCorporal);
        dificultadRespiratoria = new RuleVariable(br, Const.BRB.Symptoms.dificultadRespiratoria);

        dolorAbdominal = new RuleVariable(br, Const.BRB.Symptoms.dolorAbdominal);
        evacuacionesConstantes = new RuleVariable(br, Const.BRB.Symptoms.evacuacionesConstantes);
        acidezEstomacal = new RuleVariable(br, Const.BRB.Symptoms.acidezEstomacal);
        vomito = new RuleVariable(br, Const.BRB.Symptoms.vomito);
        hemorragiaRectal = new RuleVariable(br, Const.BRB.Symptoms.hemorragiaRectal);
        diarrea = new RuleVariable(br, Const.BRB.Symptoms.diarrea);
        evacuacionesConDolor = new RuleVariable(br, Const.BRB.Symptoms.evacuacionesConDolor);

        dolorAlOrinar = new RuleVariable(br, Const.BRB.Symptoms.dolorAlOrinar);
        sangradoAlOrinar = new RuleVariable(br, Const.BRB.Symptoms.sangradoAlOrinar);

        pielEnrogecida = new RuleVariable(br, Const.BRB.Symptoms.pielEnrogecida);
        inflamacionZona = new RuleVariable(br, Const.BRB.Symptoms.inflamacionZona);
        altaSensibilidadZona = new RuleVariable(br, Const.BRB.Symptoms.altaSensibilidadZona);

        // Instancias de CONSECUENTES de regla
        afeccion = new RuleVariable(br, Const.BRB.afeccion);
        enfermedad = new RuleVariable(br, Const.BRB.enfermedad);

        // Definicion de operadores logicos (condicionales)
        Condition equal = new Condition("=");
        Condition greater = new Condition(">");
        Condition less = new Condition("<");

        // Creacion de reglas de validacion (Base de Reglas)
        // AFECCION
        Rule dCabeza = new Rule(br, Const.BRB.Number.R1,
                new Clause[]{new Clause(afeccionCabeza, equal, Const.BRB.SI),
                        new Clause(afeccionRespiratoria, equal, Const.BRB.NO),
                        new Clause(afeccionDigestiva, equal, Const.BRB.NO),
                        new Clause(afeccionInterna, equal, Const.BRB.NO),
                        new Clause(afeccionUrinaria, equal, Const.BRB.NO),
                        new Clause(afeccionPiel, equal, Const.BRB.NO)},
                new Clause(afeccion, equal, Const.BRB.Facts.D_ENCEFALICO));
        Rule dRespiratorio = new Rule(br, Const.BRB.Number.R2,
                new Clause[]{new Clause(afeccionCabeza, equal, Const.BRB.NO),
                        new Clause(afeccionRespiratoria, equal, Const.BRB.SI),
                        new Clause(afeccionDigestiva, equal, Const.BRB.NO),
                        new Clause(afeccionInterna, equal, Const.BRB.NO),
                        new Clause(afeccionUrinaria, equal, Const.BRB.NO),
                        new Clause(afeccionPiel, equal, Const.BRB.NO)},
                new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO));
        Rule dDigestivo = new Rule(br, Const.BRB.Number.R3,
                new Clause[]{new Clause(afeccionCabeza, equal, Const.BRB.NO),
                        new Clause(afeccionRespiratoria, equal, Const.BRB.NO),
                        new Clause(afeccionDigestiva, equal, Const.BRB.SI),
                        new Clause(afeccionInterna, equal, Const.BRB.NO),
                        new Clause(afeccionUrinaria, equal, Const.BRB.NO),
                        new Clause(afeccionPiel, equal, Const.BRB.NO)},
                new Clause(afeccion, equal, Const.BRB.Facts.D_DIGESTIVO));
        Rule dInterno = new Rule(br, Const.BRB.Number.R4,
                new Clause[]{new Clause(afeccionCabeza, equal, Const.BRB.NO),
                        new Clause(afeccionRespiratoria, equal, Const.BRB.NO),
                        new Clause(afeccionDigestiva, equal, Const.BRB.NO),
                        new Clause(afeccionInterna, equal, Const.BRB.SI),
                        new Clause(afeccionUrinaria, equal, Const.BRB.NO),
                        new Clause(afeccionPiel, equal, Const.BRB.NO)},
                new Clause(afeccion, equal, Const.BRB.Facts.D_INTERNO));
        Rule dUrinario= new Rule(br, Const.BRB.Number.R5,
                new Clause[]{new Clause(afeccionCabeza, equal, Const.BRB.NO),
                        new Clause(afeccionRespiratoria, equal, Const.BRB.NO),
                        new Clause(afeccionDigestiva, equal, Const.BRB.NO),
                        new Clause(afeccionInterna, equal, Const.BRB.NO),
                        new Clause(afeccionUrinaria, equal, Const.BRB.SI),
                        new Clause(afeccionPiel, equal, Const.BRB.NO)},
                new Clause(afeccion, equal, Const.BRB.Facts.D_URINARIO));
        Rule dCutaneo = new Rule(br, Const.BRB.Number.R6,
                new Clause[]{new Clause(afeccionCabeza, equal, Const.BRB.NO),
                        new Clause(afeccionRespiratoria, equal, Const.BRB.NO),
                        new Clause(afeccionDigestiva, equal, Const.BRB.NO),
                        new Clause(afeccionInterna, equal, Const.BRB.NO),
                        new Clause(afeccionUrinaria, equal, Const.BRB.NO),
                        new Clause(afeccionPiel, equal, Const.BRB.SI)},
                new Clause(afeccion, equal, Const.BRB.Facts.D_CUTANEO));

        // ENFERMEDAD CON D.CABEZA
        Rule migrania = new Rule(br, Const.BRB.Number.R7,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_ENCEFALICO),
                        new Clause(dolorCabeza, equal, Const.BRB.SI),
                        new Clause(presionArterialAlta, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_36),
                        new Clause(temperatura, less, Const.BRB.TEMP_37),
                        new Clause(zumbidoOidos, equal, Const.BRB.SI),
                        new Clause(nauseas, equal, Const.BRB.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.NO),
                        new Clause(dolorOido, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.MIGRANIA));
        Rule infeccionOido = new Rule(br, Const.BRB.Number.R8,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_ENCEFALICO),
                        new Clause(dolorCabeza, equal, Const.BRB.NO),
                        new Clause(presionArterialAlta, equal, Const.BRB.NO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(zumbidoOidos, equal, Const.BRB.SI),
                        new Clause(nauseas, equal, Const.BRB.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.SI),
                        new Clause(dolorOido, equal, Const.BRB.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INF_OIDO));

        // ENFERMEDAD CON D.RESPIRATORIO
        Rule gripeComun = new Rule(br, Const.BRB.Number.R9,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorGarganta, equal, Const.BRB.SI),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.SI),
                        new Clause(fatiga, equal, Const.BRB.SI),
                        new Clause(congestionNasal, equal, Const.BRB.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.NO),
                        new Clause(estornudos, equal, Const.BRB.SI),
                        new Clause(dolorArticulaciones, equal, Const.BRB.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.GRIPE_COMUN));
        Rule bronquitis = new Rule(br, Const.BRB.Number.R10,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37),
                        new Clause(temperatura, less, Const.BRB.TEMP_37_5),
                        new Clause(dolorGarganta, equal, Const.BRB.SI),
                        new Clause(dolorPecho, equal, Const.BRB.SI),
                        new Clause(escurrimientoNasal, equal, Const.BRB.SI),
                        new Clause(fatiga, equal, Const.BRB.SI),
                        new Clause(congestionNasal, equal, Const.BRB.NO),
                        new Clause(dolorCabeza, equal, Const.BRB.NO),
                        new Clause(dolorCorporal, equal, Const.BRB.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.SI),
                        new Clause(estornudos, equal, Const.BRB.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.BRONQUITIS));
        /*Rule tosConFlema = new Rule(br, Const.BRB.Number.R11,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.SI),
                        new Clause(temperatura, equal, Const.BRB.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.SI),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(congestionNasal, equal, Const.BRB.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.NO),
                        new Clause(dolorCorporal, equal, Const.BRB.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.NO),
                        new Clause(estornudos, equal, Const.BRB.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.TOS_FLEMA));*/
        Rule sinusitis = new Rule(br, Const.BRB.Number.R12,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.NO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorGarganta, equal, Const.BRB.SI),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.SI),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(congestionNasal, equal, Const.BRB.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.NO),
                        new Clause(estornudos, equal, Const.BRB.SI),
                        new Clause(dolorArticulaciones, equal, Const.BRB.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.SINUSITIS));
        Rule influenza = new Rule(br, Const.BRB.Number.R13,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorGarganta, equal, Const.BRB.SI),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.SI),
                        new Clause(fatiga, equal, Const.BRB.SI),
                        new Clause(congestionNasal, equal, Const.BRB.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.SI),
                        new Clause(estornudos, equal, Const.BRB.SI),
                        new Clause(dolorArticulaciones, equal, Const.BRB.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INFLUENZA));
        Rule sinusitisBacteriana = new Rule(br, Const.BRB.Number.R14,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorGarganta, equal, Const.BRB.SI),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.SI),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(congestionNasal, equal, Const.BRB.SI),
                        new Clause(dolorCabeza, equal, Const.BRB.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.NO),
                        new Clause(estornudos, equal, Const.BRB.SI),
                        new Clause(dolorArticulaciones, equal, Const.BRB.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.SINUSITIS_BAC));
        Rule neumonia = new Rule(br, Const.BRB.Number.R15,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorGarganta, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.SI),
                        new Clause(congestionNasal, equal, Const.BRB.NO),
                        new Clause(dolorCabeza, equal, Const.BRB.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.SI),
                        new Clause(estornudos, equal, Const.BRB.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.NEUMONIA));
        Rule fibrosisPulmonar = new Rule(br, Const.BRB.Number.R16,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_36),
                        new Clause(temperatura, less, Const.BRB.TEMP_37),
                        new Clause(dolorGarganta, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.SI),
                        new Clause(congestionNasal, equal, Const.BRB.NO),
                        new Clause(dolorCabeza, equal, Const.BRB.NO),
                        new Clause(dolorCorporal, equal, Const.BRB.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.SI),
                        new Clause(estornudos, equal, Const.BRB.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.FIBROSIS_PUL));
        Rule bronquiolitis = new Rule(br, Const.BRB.Number.R17,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_RESPIRATORIO),
                        new Clause(tos, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorGarganta, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(escurrimientoNasal, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(congestionNasal, equal, Const.BRB.NO),
                        new Clause(dolorCabeza, equal, Const.BRB.SI),
                        new Clause(dolorCorporal, equal, Const.BRB.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.SI),
                        new Clause(estornudos, equal, Const.BRB.NO),
                        new Clause(dolorArticulaciones, equal, Const.BRB.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.BRONQUIOLOTIS));

        // ENFERMEDAD CON D.DIGESTIVO
        Rule infeccionEstomago = new Rule(br, Const.BRB.Number.R18,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_DIGESTIVO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorAbdominal, equal, Const.BRB.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.SI),
                        new Clause(nauseas, equal, Const.BRB.SI),
                        new Clause(acidezEstomacal, equal, Const.BRB.NO),
                        new Clause(vomito, equal, Const.BRB.SI),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.NO),
                        new Clause(diarrea, equal, Const.BRB.SI),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INF_ESTOMAGO));
        Rule estrenimiento = new Rule(br, Const.BRB.Number.R19,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_DIGESTIVO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_36),
                        new Clause(temperatura, less, Const.BRB.TEMP_37),
                        new Clause(dolorAbdominal, equal, Const.BRB.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.NO),
                        new Clause(nauseas, equal, Const.BRB.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.NO),
                        new Clause(vomito, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.NO),
                        new Clause(diarrea, equal, Const.BRB.NO),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.SI),
                        new Clause(dolorPecho, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.ESTRENIMIENTO));
        Rule indigestion = new Rule(br, Const.BRB.Number.R20,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_DIGESTIVO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_36),
                        new Clause(temperatura, less, Const.BRB.TEMP_37),
                        new Clause(dolorAbdominal, equal, Const.BRB.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.NO),
                        new Clause(nauseas, equal, Const.BRB.SI),
                        new Clause(acidezEstomacal, equal, Const.BRB.SI),
                        new Clause(vomito, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.NO),
                        new Clause(diarrea, equal, Const.BRB.NO),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INDIGESTION));
        Rule gastritis = new Rule(br, Const.BRB.Number.R21,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_DIGESTIVO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_36),
                        new Clause(temperatura, less, Const.BRB.TEMP_37),
                        new Clause(dolorAbdominal, equal, Const.BRB.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.NO),
                        new Clause(nauseas, equal, Const.BRB.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.SI),
                        new Clause(vomito, equal, Const.BRB.SI),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.SI),
                        new Clause(diarrea, equal, Const.BRB.NO),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.SI),
                        new Clause(dolorPecho, equal, Const.BRB.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.GASTRITIS));
        Rule colitis = new Rule(br, Const.BRB.Number.R22,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_DIGESTIVO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37),
                        new Clause(dolorAbdominal, equal, Const.BRB.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.NO),
                        new Clause(nauseas, equal, Const.BRB.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.NO),
                        new Clause(vomito, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.SI),
                        new Clause(diarrea, equal, Const.BRB.SI),
                        new Clause(evacuacionesConDolor, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.COLITIS));

        // ENFERMEDAD CON D.INTERNO
        Rule apendicitis = new Rule(br, Const.BRB.Number.R23,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_INTERNO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorAbdominal, equal, Const.BRB.SI),
                        new Clause(nauseas, equal, Const.BRB.SI),
                        new Clause(vomito, equal, Const.BRB.SI),
                        new Clause(tos, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.SI),
                        new Clause(dolorGarganta, equal, Const.BRB.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.NO),
                        new Clause(diarrea, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.APENDICITIS));
        Rule esofagitis = new Rule(br, Const.BRB.Number.R24,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_INTERNO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_36),
                        new Clause(temperatura, less, Const.BRB.TEMP_37),
                        new Clause(dolorAbdominal, equal, Const.BRB.SI),
                        new Clause(nauseas, equal, Const.BRB.SI),
                        new Clause(vomito, equal, Const.BRB.SI),
                        new Clause(tos, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.SI),
                        new Clause(acidezEstomacal, equal, Const.BRB.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.SI),
                        new Clause(hemorragiaRectal, equal, Const.BRB.NO),
                        new Clause(diarrea, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.ESOFAGITIS));
        Rule pancreatitis = new Rule(br, Const.BRB.Number.R25,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_INTERNO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5),
                        new Clause(dolorAbdominal, equal, Const.BRB.SI),
                        new Clause(nauseas, equal, Const.BRB.SI),
                        new Clause(vomito, equal, Const.BRB.SI),
                        new Clause(tos, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.SI),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.NO),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.SI),
                        new Clause(diarrea, equal, Const.BRB.SI)},
                new Clause(enfermedad, equal, Const.BRB.Facts.PANCREATITIS));
        Rule anemia = new Rule(br, Const.BRB.Number.R26,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_INTERNO),
                        new Clause(temperatura, greater, Const.BRB.TEMP_36),
                        new Clause(temperatura, less, Const.BRB.TEMP_37),
                        new Clause(dolorAbdominal, equal, Const.BRB.NO),
                        new Clause(nauseas, equal, Const.BRB.NO),
                        new Clause(vomito, equal, Const.BRB.SI),
                        new Clause(tos, equal, Const.BRB.NO),
                        new Clause(dolorPecho, equal, Const.BRB.NO),
                        new Clause(acidezEstomacal, equal, Const.BRB.NO),
                        new Clause(dolorEspalda, equal, Const.BRB.NO),
                        new Clause(dificultadRespiratoria, equal, Const.BRB.NO),
                        new Clause(fatiga, equal, Const.BRB.SI),
                        new Clause(evacuacionesConstantes, equal, Const.BRB.NO),
                        new Clause(dolorGarganta, equal, Const.BRB.NO),
                        new Clause(hemorragiaRectal, equal, Const.BRB.NO),
                        new Clause(diarrea, equal, Const.BRB.NO)},
                new Clause(enfermedad, equal, Const.BRB.Facts.ANEMIA));

        // ENFERMEDAD CON D.URINARIO
        Rule infeccionUrinaria = new Rule(br, Const.BRB.Number.R27,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_URINARIO),
                        new Clause(nauseas, equal, Const.BRB.SI),
                        new Clause(dolorAlOrinar, equal, Const.BRB.SI),
                        new Clause(sangradoAlOrinar, equal, Const.BRB.SI),
                        new Clause(dolorEspalda, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_37_5)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INF_URINARIA));

        // ENFERMEDAD CON D.CUTANEO
        Rule infeccionPiel = new Rule(br, Const.BRB.Number.R28,
                new Clause[]{new Clause(afeccion, equal, Const.BRB.Facts.D_CUTANEO),
                        new Clause(pielEnrogecida, equal, Const.BRB.SI),
                        new Clause(inflamacionZona, equal, Const.BRB.SI),
                        new Clause(altaSensibilidadZona, equal, Const.BRB.SI),
                        new Clause(temperatura, greater, Const.BRB.TEMP_36),
                        new Clause(temperatura, less, Const.BRB.TEMP_37)},
                new Clause(enfermedad, equal, Const.BRB.Facts.INF_PIEL));
    }
}
